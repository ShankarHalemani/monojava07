package com.techlabs.model;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private String transactionId;
    private String productId;
    private String transactionType;
    private int productQuantity;
    private Date date;

    public Transaction(String transactionId, String productId, String transactionType, int productQuantity, Date date) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.transactionType = transactionType;
        this.productQuantity = productQuantity;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "\n" +
                "Transaction Id : " + transactionId + '\n' +
                "Product Id : " + productId + '\n' +
                "Transaction Type : " + transactionType + '\n' +
                "Product Quantity : " + productQuantity +'\n'+
                "Date : " + date +'\n';
    }
}
