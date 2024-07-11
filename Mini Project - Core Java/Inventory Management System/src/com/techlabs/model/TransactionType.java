package com.techlabs.model;

public interface TransactionType {
    void execute(String productId, int productQuantity);
}
