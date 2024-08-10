package com.techlabs.app.service;

import com.techlabs.app.config.EmailSender;
import com.techlabs.app.dto.AccountResponseDTO;
import com.techlabs.app.dto.EmailDTO;
import com.techlabs.app.dto.TransactionResponseDTO;
import com.techlabs.app.entity.Account;
import com.techlabs.app.entity.Bank;
import com.techlabs.app.entity.Customer;
import com.techlabs.app.entity.Transaction;
import com.techlabs.app.exception.AccountRelatedException;
import com.techlabs.app.exception.BankRealtedException;
import com.techlabs.app.exception.CustomerRelatedException;
import com.techlabs.app.exception.TransactionRelatedException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.AccountRepository;
import com.techlabs.app.repository.BankRepository;
import com.techlabs.app.repository.CustomerRepository;
import com.techlabs.app.repository.TransactionRepository;
import com.techlabs.app.util.PagedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private Mapper mapper;

    @Override
    public PagedResponse<AccountResponseDTO> getAllAccounts(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Account> accounts = accountRepository.findAll(pageable);
        if (accounts.getContent().isEmpty()) {
            logger.error("No Accounts Found");
            throw new BankRealtedException("No Accounts Found");
        }

        List<AccountResponseDTO> accountResponseList = mapper.getAccountResponseList(accounts.getContent());
        return new PagedResponse<AccountResponseDTO>(accountResponseList, accounts.getNumber(), accounts.getNumberOfElements(),
                accounts.getTotalElements(), accounts.getTotalPages(), accounts.isLast());

    }

    @Override
    public AccountResponseDTO getAccountByAccountNumber(long accountNumber) {
        logger.info("Fetching account with account number: {}", accountNumber);
        Account account = accountRepository.findById(accountNumber).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", accountNumber);
            return new AccountRelatedException("Account with account number : " + accountNumber + " is not available");
        });
        return mapper.accountEntityToResponse(account);
    }

    @Override
    public AccountResponseDTO createNewAccount(long customerId, long bankId) {
        logger.info("Creating new account for customer ID: {} in bank ID: {}", customerId, bankId);
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> {
            logger.error("Customer with ID: {} not found", customerId);
            return new CustomerRelatedException("Customer with ID : " + customerId + " is not found");
        });
        if (!customer.isActive()) {
            logger.error("Customer with ID: {} is not active", customerId);
            throw new CustomerRelatedException("Customer with ID : " + customerId + " is not active");
        }

        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> {
            logger.error("Bank with ID: {} not found", bankId);
            return new BankRealtedException("Bank with ID : " + bankId + " is not found");
        });
        if (!bank.isActive()) {
            logger.error("Bank with ID: {} is not active", bankId);
            throw new BankRealtedException("Bank with ID : " + bankId + " is not active");
        }

        Account account = new Account();
        account.setBank(bank);
        account.setCustomer(customer);
        account.setBalance(1000);
        account.setActive(true);
        account.setSentTransactions(new ArrayList<>());
        account.setReceivedTransactions(new ArrayList<>());
        accountRepository.save(account);

        bank.getAccounts().add(account);
        bankRepository.save(bank);
        customer.setTotalBalance(1000 + customer.getTotalBalance());
        customer.getAccounts().add(account);
        customerRepository.save(customer);

        logger.info("New account created with account number: {}", account.getAccountNumber());

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setTo(customer.getUser().getUsername());
        emailDTO.setSubject("Regarding new Account Creation");
        String body = "Welcome to " + bank.getFullName() + ". Your account created with account number "
                + account.getAccountNumber();
        emailDTO.setBody(body);

        emailSender.sendMailWithAttachement(emailDTO);
        return mapper.accountEntityToResponse(account);
    }

    @Override
    public AccountResponseDTO updateAccountBalance(long accountNumber, double amount) {
        logger.info("Updating balance for account number: {} by amount: {}", accountNumber, amount);
        Account account = accountRepository.findById(accountNumber).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", accountNumber);
            return new AccountRelatedException("Account with account number : " + accountNumber + " is not available");
        });

        if (!account.isActive()) {
            logger.error("Account with account number: {} is not active", accountNumber);
            throw new AccountRelatedException("Account with account number : " + accountNumber + " is not active");
        }

        double currentBalance = account.getBalance();
        double updatedBalance = currentBalance + amount;
        account.setBalance(updatedBalance);

        Customer customer = account.getCustomer();
        double totalBalance = customer.getAccounts().stream()
                .filter(Account::isActive)
                .mapToDouble(Account::getBalance)
                .sum();
        customer.setTotalBalance(totalBalance);

        customerRepository.save(customer);
        accountRepository.save(account);

        Bank bank = account.getBank();
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setTo(customer.getUser().getUsername());
        emailDTO.setSubject("Account Balance Updated");
        String body = "Welcome to " + bank.getFullName() + ". Your account credited with amount "
                + amount;
        emailDTO.setBody(body);

        emailSender.sendMailWithAttachement(emailDTO);

        logger.info("Account number: {} updated with new balance: {}", accountNumber, updatedBalance);
        return mapper.accountEntityToResponse(account);
    }

    @Override
    public void deleteAccount(long accountNumber) {
        logger.info("Deleting account with account number: {}", accountNumber);
        Account account = accountRepository.findById(accountNumber).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", accountNumber);
            return new AccountRelatedException("Account with account number : " + accountNumber + " is not available");
        });
        account.setActive(false);
        account.setBalance(0);
        Customer customer = account.getCustomer();
        double totalBalance = customer.getAccounts().stream()
                .filter(Account::isActive)
                .mapToDouble(Account::getBalance)
                .sum();
        customer.setTotalBalance(totalBalance);

        customerRepository.save(customer);
        accountRepository.save(account);

        Bank bank = account.getBank();
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setTo(customer.getUser().getUsername());
        emailDTO.setSubject("Account Closing Update");
        String body = "Your account in the "+bank.getFullName()+" has been deleted successfully";
        emailDTO.setBody(body);

        emailSender.sendMailWithAttachement(emailDTO);

        logger.info("Account with account number: {} has been deleted", accountNumber);
    }

    @Override
    public AccountResponseDTO activateAccount(long accountNumber) {
        logger.info("Activating account with account number: {}", accountNumber);
        Account account = accountRepository.findById(accountNumber).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", accountNumber);
            return new AccountRelatedException("Account with account number : " + accountNumber + " is not available");
        });

        Bank bank = account.getBank();
        if (!bank.isActive()) {
            logger.error("Bank with ID: {} is not active", bank.getBankId());
            throw new BankRealtedException("Bank with ID : " + bank.getBankId() + " is not active");
        }

        Customer customer = account.getCustomer();
        if (!customer.isActive()) {
            logger.error("Customer with ID: {} is not active", customer.getCustomerId());
            throw new CustomerRelatedException("Customer with ID : " + customer.getCustomerId() + " is not active");
        }

        if (account.isActive()) {
            logger.error("Account with account number: {} is already activated", accountNumber);
            throw new AccountRelatedException("Account with account number : " + accountNumber + " is already activated");
        }
        account.setActive(true);
        account.setBalance(1000);
        customer = account.getCustomer();
        double totalBalance = customer.getAccounts().stream()
                .filter(Account::isActive)
                .mapToDouble(Account::getBalance)
                .sum();
        customer.setTotalBalance(totalBalance);

        customerRepository.save(customer);
        accountRepository.save(account);


        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setTo(customer.getUser().getUsername());
        emailDTO.setSubject("Account Closing Update");
        String body = "Your account in the "+bank.getFullName()+" has been activated successfully";
        emailDTO.setBody(body);

        emailSender.sendMailWithAttachement(emailDTO);

        logger.info("Account with account number: {} has been activated", accountNumber);
        return mapper.accountEntityToResponse(account);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactions(long accountNumber) {
        logger.info("Fetching all transactions for account number: {}", accountNumber);

        Account account = accountRepository.findById(accountNumber).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", accountNumber);
            return new AccountRelatedException("Account with account number: " + accountNumber + " is not available");
        });

        List<Transaction> transactions = new ArrayList<>(account.getSentTransactions());
        transactions.addAll(account.getReceivedTransactions());

        logger.info("Successfully fetched transactions for account number: {}", accountNumber);
        return mapper.getTransactionResponseList(transactions);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactionsBetweenRange(long accountNumber, LocalDateTime startDate, LocalDateTime endDate) {
        logger.info("Fetching transactions for account number {} between dates {} and {}", accountNumber, startDate, endDate);

        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new AccountRelatedException("Account with account number: " + accountNumber + " is not available"));

        List<Transaction> sentTransactions = transactionRepository
                .findBySenderAccountNumber_AccountNumberAndTransactionTimestampBetween(accountNumber, startDate, endDate);

        List<Transaction> receivedTransactions = transactionRepository
                .findByReceiverAccountNumber_AccountNumberAndTransactionTimestampBetween(accountNumber, startDate, endDate);

        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(sentTransactions);
        transactions.addAll(receivedTransactions);

        if (transactions.isEmpty()) {
            logger.warn("No transactions found for account number {} between dates {} and {}", accountNumber, startDate, endDate);
            throw new TransactionRelatedException("No transaction records found for account :" + accountNumber + " between date : " + startDate + " and date : " + endDate);
        } else {
            logger.info("Found {} transactions for account number {} between dates {} and {}", transactions.size(), accountNumber, startDate, endDate);
        }

        return mapper.getTransactionResponseList(transactions);
    }


    @Override
    public List<TransactionResponseDTO> getTransactionBetweenRange(LocalDateTime startDate, LocalDateTime endDate) {
        logger.info("Fetching all transactions between dates {} and {}", startDate, endDate);

        List<Transaction> transactions = transactionRepository
                .findByTransactionTimestampBetween(startDate, endDate);
        if (transactions.isEmpty()) {
            logger.warn("No transactions found between dates {} and {}", startDate, endDate);
            throw new TransactionRelatedException("There are no transactions between : "
                    + startDate + " and : " + endDate);
        } else {
            logger.info("Found {} transactions between dates {} and {}", transactions.size(), startDate, endDate);
        }

        return mapper.getTransactionResponseList(transactions);
    }

    @Override
    public List<TransactionResponseDTO> getAllAccountsTransactions() {
        logger.info("Fetching all transactions for all accounts");

        List<Account> allAccounts = accountRepository.findAll();
        List<Transaction> allTransactions = new ArrayList<>();

        for (Account account : allAccounts) {
            allTransactions.addAll(account.getSentTransactions());
        }

        logger.info("Found {} total transactions for all accounts", allTransactions.size());

        return mapper.getTransactionResponseList(allTransactions);
    }
}
