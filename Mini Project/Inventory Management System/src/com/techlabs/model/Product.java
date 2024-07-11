package com.techlabs.model;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productId;
    private String productName;
    private String productDescription;
    private int productQuantity;
    private double productPrice;

    public Product(String productId, String productName, String productDescription, int productQuantity, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "\n" +
                "Product Id : " + productId + '\n' +
                "Product Name : " + productName + '\n' +
                "Product Description : " + productDescription + '\n' +
                "Product Quantity : " + productQuantity +'\n'+
                "Product Price : " + productPrice + '\n';
    }
}
