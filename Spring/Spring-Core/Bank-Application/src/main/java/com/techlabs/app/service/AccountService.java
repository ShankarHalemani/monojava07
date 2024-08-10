package com.techlabs.app.service;

import com.techlabs.app.dto.AccountResponseDTO;
import com.techlabs.app.dto.TransactionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountService {
    List<AccountResponseDTO> getAllAccounts();

    AccountResponseDTO getAccountByAccountNumber(long accountNumber);

    AccountResponseDTO createNewAccount(long customerId, long bankId);

    AccountResponseDTO updateAccountBalance(long accountNumber, double amount);

    void deleteAccount(long accountNumber);

    AccountResponseDTO activateAccount(long accountNumber);

    List<TransactionResponseDTO> getAllTransactions(long accountNumber);

    List<TransactionResponseDTO> getAllTransactionsBetweenRange(long accountNumber, LocalDateTime startDateTimestamp, LocalDateTime endDateTimestamp);

    List<TransactionResponseDTO> getTransactionBetweenRange(LocalDateTime startDateTimestamp, LocalDateTime endDateTimestamp);

    List<TransactionResponseDTO> getAllAccountsTransactions();
}
