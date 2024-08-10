package com.techlabs.app.service;

import com.techlabs.app.dto.BankRequestDTO;
import com.techlabs.app.dto.BankResponseDTO;
import com.techlabs.app.entity.Account;
import com.techlabs.app.entity.Bank;
import com.techlabs.app.entity.Customer;
import com.techlabs.app.exception.BankRealtedException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.AccountRepository;
import com.techlabs.app.repository.BankRepository;
import com.techlabs.app.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService{
    private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Mapper mapper;


    @Override
    public List<BankResponseDTO> getAllBanks() {
        logger.info("Fetching all banks");
        List<Bank> banks = bankRepository.findAll();
        return mapper.getBankResponseList(banks);
    }

    @Override
    public BankResponseDTO getBankById(long bankId) {
        logger.info("Fetching bank with ID: {}", bankId);
        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> {
            logger.error("Bank with ID: {} is not found", bankId);
            return new BankRealtedException("Bank with ID : " + bankId + " is not found");
        });
        return mapper.bankEntityToResponse(bank);
    }

    @Override
    public BankResponseDTO addNewBank(BankRequestDTO bankRequestDTO) {
        logger.info("Adding new bank with name: {}", bankRequestDTO.getFullName());
        Bank bank = new Bank();
        bank.setFullName(bankRequestDTO.getFullName());
        bank.setAbbreviation(bankRequestDTO.getAbbreviation());
        bank.setActive(true);
        List<Account> accounts = new ArrayList<>();
        bank.setAccounts(accounts);
        bankRepository.save(bank);
        logger.info("Bank with name: {} added successfully", bankRequestDTO.getFullName());
        return mapper.bankEntityToResponse(bank);
    }

    @Override
    public BankResponseDTO updateBank(BankRequestDTO bankRequestDTO) {
        logger.info("Updating bank with ID: {}", bankRequestDTO.getBankId());
        Bank bank = bankRepository.findById(bankRequestDTO.getBankId()).orElseThrow(() -> {
            logger.error("Bank with ID: {} is not found", bankRequestDTO.getBankId());
            return new BankRealtedException("Bank with ID : " + bankRequestDTO.getBankId() + " is not found");
        });

        if (!bank.isActive()) {
            logger.error("Bank with ID: {} is not active", bankRequestDTO.getBankId());
            throw new BankRealtedException("Bank with ID : " + bankRequestDTO.getBankId() + " is not active");
        }

        bank.setFullName(bankRequestDTO.getFullName());
        bank.setAbbreviation(bankRequestDTO.getAbbreviation());
        bankRepository.save(bank);
        logger.info("Bank with ID: {} updated successfully", bankRequestDTO.getBankId());
        return mapper.bankEntityToResponse(bank);
    }

    @Override
    public BankResponseDTO activateBank(long bankId) {
        logger.info("Activating bank with ID: {}", bankId);
        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> {
            logger.error("Bank with ID: {} is not found", bankId);
            return new BankRealtedException("Bank with ID : " + bankId + " is not found");
        });

        if (bank.isActive()) {
            logger.error("Bank with ID: {} is already active", bankId);
            throw new BankRealtedException("Bank with ID : " + bankId + " is already active");
        }

        bank.setActive(true);
        Bank updatedBank = bankRepository.save(bank);
        logger.info("Bank with ID: {} activated successfully", bankId);
        return mapper.bankEntityToResponse(updatedBank);
    }

    @Override
    public void deleteBankById(long bankId) {
        logger.info("Deleting bank with ID: {}", bankId);
        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> {
            logger.error("Bank with ID: {} is not found", bankId);
            return new BankRealtedException("Bank with ID : " + bankId + " is not found");
        });

        if (!bank.isActive()) {
            logger.error("Bank with ID: {} is already deleted", bankId);
            throw new BankRealtedException("Bank with ID : " + bankId + " is already deleted");
        }

        bank.setActive(false);
        bank.getAccounts().forEach(account -> {
            account.setActive(false);
            account.setBalance(0);
            Customer customer = account.getCustomer();
            double totalBalance = customer.getAccounts().stream()
                    .filter(Account::isActive)
                    .mapToDouble(Account::getBalance)
                    .sum();
            customer.setTotalBalance(totalBalance);


            customerRepository.save(customer);
        });

        accountRepository.saveAll(bank.getAccounts());
        bankRepository.save(bank);
        logger.info("Bank with ID: {} deleted successfully", bankId);
    }
}
