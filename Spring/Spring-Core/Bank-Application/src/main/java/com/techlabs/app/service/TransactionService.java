package com.techlabs.app.service;

import com.techlabs.app.dto.TransactionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {
    List<TransactionResponseDTO> getAllTransactions(long accountNumber);

//    TransactionResponseDTO getTransactionById(long transactionId);

    TransactionResponseDTO makeTransaction(long senderAccount, long receiverAccount, double amount);

    List<TransactionResponseDTO> getAllAccountsTransactions();

    List<TransactionResponseDTO> getAllTransactionsForUserBetweenRange(String currentUsername, LocalDateTime startDateTimestamp, LocalDateTime endDateTimestamp);

    List<TransactionResponseDTO> getTransactionsForAccountOfUserBetweenRange(long accountNumber, String currentUsername, LocalDateTime startDateTimestamp, LocalDateTime endDateTimestamp);
}
