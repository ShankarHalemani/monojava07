package com.techlabs.app.controller;

import com.techlabs.app.dto.AccountResponseDTO;
import com.techlabs.app.dto.TransactionResponseDTO;
import com.techlabs.app.service.AccountService;
import com.techlabs.app.util.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Get All Accounts")
    @GetMapping()
    public ResponseEntity<PagedResponse<AccountResponseDTO>> getAllAccounts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size,
            @RequestParam(name = "sortBy", defaultValue = "accountNumber") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction) {
        logger.info("Fetching All The Accounts");
        PagedResponse<AccountResponseDTO> accountResponseDTOS = accountService.getAllAccounts(page, size, sortBy, direction);

        return new ResponseEntity<>(accountResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get account by account number")
    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> getAccountByAccountNumber(@PathVariable(name = "accountNumber") long accountNumber) {
        logger.info("Fetching account with account number: {}", accountNumber);
        AccountResponseDTO accountResponseDTO = accountService.getAccountByAccountNumber(accountNumber);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Create a new account")
    @PostMapping("/{customerId}/{bankId}")
    public ResponseEntity<AccountResponseDTO> createNewAccount(@PathVariable(name = "customerId") long customerId,
                                                               @PathVariable(name = "bankId") long bankId) {
        logger.info("Creating new account for customerId: {} and bankId: {}", customerId, bankId);
        AccountResponseDTO accountResponseDTO = accountService.createNewAccount(customerId, bankId);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Add balance to an account")
    @PostMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> addAccountBalance(@PathVariable(name = "accountNumber") long accountNumber,
                                                                @RequestParam(name = "amount") double amount) {
        logger.info("Adding balance to account number: {}", accountNumber);
        AccountResponseDTO accountResponseDTO = accountService.updateAccountBalance(accountNumber, amount);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Activate an account")
    @PutMapping("/activate/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> activateAccount(@PathVariable(name = "accountNumber") long accountNumber) {
        logger.info("Activating account with account number: {}", accountNumber);
        AccountResponseDTO accountResponseDTO = accountService.activateAccount(accountNumber);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Delete an account by account number")
    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Object> deleteAccount(@PathVariable(name = "accountNumber") long accountNumber) {
        logger.info("Deleting account with account number: {}", accountNumber);
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.ok("Account with account number: " + accountNumber + " deleted successfully");
    }

    @Operation(summary = "Get all transactions of a specific account")
    @GetMapping("/transactions/{accountNumber}")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsOfCurrentUserAccount(
            @PathVariable(name = "accountNumber") long accountNumber) {
        logger.info("Fetching all transactions for account number: {}", accountNumber);
        List<TransactionResponseDTO> transactionResponseDTOS = accountService.getAllTransactions(accountNumber);
        return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get all transactions for a particular account within a date range")
    @GetMapping("/transactions/{accountNumber}/dates")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsForAccountBetweenRange(
            @PathVariable(name = "accountNumber") long accountNumber,
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate) {

        logger.info("Fetching transactions for account number {} between dates {} and {}"
                , accountNumber, startDate, endDate);
        LocalDateTime startDateTimestamp = startDate.atStartOfDay();
        LocalDateTime endDateTimestamp = endDate.atStartOfDay();
        List<TransactionResponseDTO> transactionResponseDTOS = accountService
                .getAllTransactionsBetweenRange(accountNumber, startDateTimestamp, endDateTimestamp);
        return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get all transactions for all accounts within a date range")
    @GetMapping("/transactions/dates")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsBetweenDateRange(
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate) {

        logger.info("Fetching all transactions for all accounts between dates {} and {}", startDate, endDate);
        LocalDateTime startDateTimestamp = startDate.atStartOfDay();
        LocalDateTime endDateTimestamp = endDate.atStartOfDay();
        List<TransactionResponseDTO> transactionResponseDTOS = accountService
                .getTransactionBetweenRange(startDateTimestamp, endDateTimestamp);
        return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get all transactions for all accounts of the all users")
    @GetMapping("/transactions/all")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactionsForAllAccounts() {

        logger.info("Fetching all transactions for all accounts of all customers");
        List<TransactionResponseDTO> transactionResponseDTOS = accountService
                .getAllAccountsTransactions();
        return new ResponseEntity<>(transactionResponseDTOS, HttpStatus.OK);
    }


}
