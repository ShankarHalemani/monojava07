package com.techlabs.model;

import java.util.UUID;

public class UIDGenerator implements IDGenerator{

    @Override
    public String generateProductId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String generateSupplierId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
