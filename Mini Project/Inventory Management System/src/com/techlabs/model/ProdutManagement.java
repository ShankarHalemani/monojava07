package com.techlabs.model;

import java.util.List;

public interface ProdutManagement {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productId);
    Product getProduct(String productId);
    List<Product> getAllProducts();
}
