package com.techlabs.app.service;

import com.techlabs.app.dto.TransactionResponseDTO;
import com.techlabs.app.entity.Account;
import com.techlabs.app.entity.Customer;
import com.techlabs.app.entity.Transaction;
import com.techlabs.app.entity.User;
import com.techlabs.app.exception.AccountRelatedException;
import com.techlabs.app.exception.UserRelatedException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.AccountRepository;
import com.techlabs.app.repository.TransactionRepository;
import com.techlabs.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<TransactionResponseDTO> getAllAccountsTransactions() {

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).orElseThrow(() -> {
            logger.error("User with username: {} not found", currentUsername);
            return new UserRelatedException("User with username : " + currentUsername + " not found");
        });

        Customer customer = user.getCustomer();
        List<Account> accounts = customer.getAccounts();

        List<Transaction> allAccountsTransactions = new ArrayList<>();
        for (Account account : accounts) {
            allAccountsTransactions.addAll(account.getSentTransactions());
            allAccountsTransactions.addAll(account.getReceivedTransactions());
        }

        logger.info("Successfully fetched transactions for Customer : {}", currentUsername);
        return mapper.getTransactionResponseList(allAccountsTransactions);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactions(long accountNumber) {
        logger.info("Fetching all transactions for account number: {}", accountNumber);

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findById(accountNumber).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", accountNumber);
            return new AccountRelatedException("Account with account number: " + accountNumber + " is not available");
        });

        if (!account.getCustomer().getUser().getUsername().equals(currentUsername)) {
            logger.error("Unauthorized access to transactions of account number: {}", accountNumber);
            throw new AccountRelatedException("Unauthorized access to transactions of account number: " + accountNumber);
        }

        List<Transaction> transactions = new ArrayList<>(account.getSentTransactions());
        transactions.addAll(account.getReceivedTransactions());

        logger.info("Successfully fetched transactions for account number: {}", accountNumber);
        return mapper.getTransactionResponseList(transactions);
    }


//    @Override
//    public TransactionResponseDTO getTransactionById(long transactionId) {
//        logger.info("Fetching transaction with ID: {}", transactionId);
//        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> {
//            logger.error("Transaction with ID: {} could not be found", transactionId);
//            return new TransactionRelatedException("Transaction with ID : " + transactionId + " could not be found");
//        });
//        return mapper.transactionEntityToResponse(transaction);
//    }


    @Override
    public TransactionResponseDTO makeTransaction(long senderAccount, long receiverAccount, double amount) {
        logger.info("Making transaction from sender account: {} to receiver account: {} with amount: {}", senderAccount, receiverAccount, amount);

        Account sender = accountRepository.findById(senderAccount).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", senderAccount);
            return new AccountRelatedException("Account with account number : " + senderAccount + " is not available");
        });

        if (!sender.isActive()) {
            logger.error("Account with account number: {} is not active", senderAccount);
            throw new AccountRelatedException("Account with account number : " + senderAccount + " is not active");
        }

        Account receiver = accountRepository.findById(receiverAccount).orElseThrow(() -> {
            logger.error("Account with account number: {} is not available", receiverAccount);
            return new AccountRelatedException("Account with account number : " + receiverAccount + " is not available");
        });

        if (!receiver.isActive()) {
            logger.error("Account with account number: {} is not active", receiverAccount);
            throw new AccountRelatedException("Account with account number : " + receiverAccount + " is not active");
        }

        if (sender.getBalance() < amount) {
            logger.error("Insufficient balance in sender account: {}", senderAccount);
            throw new AccountRelatedException("Insufficient Balance in sender account : " + senderAccount);
        }

        Transaction transaction = new Transaction();
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        transaction.setTransactionTimestamp(LocalDateTime.now());
        transaction.setAmount(amount);
        transaction.setSenderAccountNumber(sender);
        transaction.setReceiverAccountNumber(receiver);

        sender.getSentTransactions().add(transaction);
        receiver.getReceivedTransactions().add(transaction);

        Customer sendingCustomer = sender.getCustomer();
        Customer receivingCustomer = receiver.getCustomer();

        double sendingCustomerTotalBalance = sendingCustomer.getAccounts().stream().mapToDouble(Account::getBalance).sum();
        sendingCustomer.setTotalBalance(sendingCustomerTotalBalance);

        double receivingCustomerTotalBalance = receivingCustomer.getAccounts().stream().mapToDouble(Account::getBalance).sum();
        receivingCustomer.setTotalBalance(receivingCustomerTotalBalance);

        transactionRepository.save(transaction);
        accountRepository.save(sender);
        accountRepository.save(receiver);

        logger.info("Transaction from account: {} to account: {} completed successfully", senderAccount, receiverAccount);
        return mapper.transactionEntityToResponse(transaction);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactionsForUserBetweenRange(String username, LocalDateTime startDate, LocalDateTime endDate) {
        logger.info("Fetching all transactions for user {} between dates {} and {}", username, startDate, endDate);

        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserRelatedException("User with username: " + username + " not found"));

        Customer customer = user.getCustomer();
        List<Account> accounts = customer.getAccounts();
        List<Transaction> allTransactions = new ArrayList<>();

        for (Account account : accounts) {
            allTransactions.addAll(transactionRepository.findBySenderAccountNumber_AccountNumberAndTransactionTimestampBetween(
                    account.getAccountNumber(), startDate, endDate));
            allTransactions.addAll(transactionRepository.findByReceiverAccountNumber_AccountNumberAndTransactionTimestampBetween(
                    account.getAccountNumber(), startDate, endDate));
        }

        logger.info("Found {} transactions for user {} between dates {} and {}",
                allTransactions.size(), username, startDate, endDate);

        return mapper.getTransactionResponseList(allTransactions);
    }


    @Override
    public List<TransactionResponseDTO> getTransactionsForAccountOfUserBetweenRange(long accountNumber, String username, LocalDateTime startDate, LocalDateTime endDate) {
        logger.info("Fetching transactions for account number {} of user {} between dates {} and {}",
                accountNumber, username, startDate, endDate);

        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new AccountRelatedException("Account with account number: " + accountNumber + " is not available"));

        if (!account.getCustomer().getUser().getUsername().equals(username)) {
            throw new AccountRelatedException("Unauthorized access to account number: " + accountNumber);
        }

        List<Transaction> sentTransactions = transactionRepository.findBySenderAccountNumber_AccountNumberAndTransactionTimestampBetween(
                accountNumber, startDate, endDate);
        List<Transaction> receivedTransactions = transactionRepository.findByReceiverAccountNumber_AccountNumberAndTransactionTimestampBetween(
                accountNumber, startDate, endDate);

        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(sentTransactions);
        transactions.addAll(receivedTransactions);

        logger.info("Found {} transactions for account number {} of user {} between dates {} and {}",
                transactions.size(), accountNumber, username, startDate, endDate);

        return mapper.getTransactionResponseList(transactions);
    }

}
