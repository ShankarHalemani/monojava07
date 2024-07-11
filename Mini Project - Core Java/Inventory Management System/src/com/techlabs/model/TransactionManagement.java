package com.techlabs.model;

import java.util.List;

public interface TransactionManagement {
    List<Transaction> getTransactionHistory(String productId);
    List<Transaction> getAllTransactions();
}
