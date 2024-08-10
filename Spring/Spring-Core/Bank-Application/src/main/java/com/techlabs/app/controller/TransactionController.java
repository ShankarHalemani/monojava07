package com.techlabs.app.controller;

import com.techlabs.app.dto.TransactionResponseDTO;
import com.techlabs.app.exception.AccountRelatedException;
import com.techlabs.app.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "Get all transactions of all accounts of logged customer")
    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsOfCurrentUserAccounts() {
        logger.info("Fetching all transactions for all account of logger customer");
        List<TransactionResponseDTO> transactionResponseDTOS = transactionService.getAllAccountsTransactions();
        return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get all transactions of a specific account of logged customer")
    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsOfCurrentUserAccount(@PathVariable(name = "accountNumber") long accountNumber) {
        logger.info("Fetching all transactions for account number: {}", accountNumber);
        try {
            List<TransactionResponseDTO> transactionResponseDTOS = transactionService.getAllTransactions(accountNumber);
            return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
        } catch (AccountRelatedException e) {
            logger.error("Error fetching transactions for account number: {}", accountNumber, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // or HttpStatus.FORBIDDEN based on the specific case
        }
    }


//    @Operation(summary = "Get transaction by ID")
//    @GetMapping("/transaction/{transactionId}")
//    public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable(name = "transactionId") long transactionId) {
//        logger.info("Fetching transaction with ID: {}", transactionId);
//        try {
//            TransactionResponseDTO transactionResponseDTO = transactionService.getTransactionById(transactionId);
//            return new ResponseEntity<>(transactionResponseDTO, HttpStatus.OK);
//        } catch (TransactionRelatedException e) {
//            logger.error("Error fetching transaction with ID: {}", transactionId, e);
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    @Operation(summary = "Make a new transaction")
    @PostMapping("/{senderAccount}/{receiverAccount}")
    public ResponseEntity<TransactionResponseDTO> newTransaction(@PathVariable(name = "senderAccount") long senderAccount,
                                                                 @PathVariable(name = "receiverAccount") long receiverAccount,
                                                                 @RequestParam(name = "amount") double amount) {
        logger.info("Making a transaction from account {} to account {} for amount {}", senderAccount, receiverAccount, amount);
        TransactionResponseDTO transactionResponseDTO = transactionService.makeTransaction(senderAccount, receiverAccount, amount);
        return new ResponseEntity<>(transactionResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all transactions for all accounts of the current user within a date range")
    @GetMapping("/dates")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsForAllAccountsBetweenRange(
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate) {

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("Fetching all transactions for all accounts of user {} between dates {} and {}",
                currentUsername, startDate, endDate);

        LocalDateTime startDateTimestamp = startDate.atStartOfDay();
        LocalDateTime endDateTimestamp = endDate.atStartOfDay();

        List<TransactionResponseDTO> transactionResponseDTOS = transactionService
                .getAllTransactionsForUserBetweenRange(currentUsername, startDateTimestamp, endDateTimestamp);

        return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get all transactions for a particular account of the current user within a date range")
    @GetMapping("/{accountNumber}/dates")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsForAccountBetweenRange(
            @PathVariable(name = "accountNumber") long accountNumber,
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate) {

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("Fetching transactions for account number {} of user {} between dates {} and {}",
                accountNumber, currentUsername, startDate, endDate);

        LocalDateTime startDateTimestamp = startDate.atStartOfDay();
        LocalDateTime endDateTimestamp = endDate.atStartOfDay();

        List<TransactionResponseDTO> transactionResponseDTOS = transactionService
                .getTransactionsForAccountOfUserBetweenRange(accountNumber, currentUsername, startDateTimestamp, endDateTimestamp);

        return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
    }


}
