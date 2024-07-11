package com.techlabs.model;

import java.util.List;

public interface DataPersistance {
    void saveProducts(List<Product> products);
    List<Product> loadProducts();
    void saveSuppliers(List<Supplier> suppliers);
    List<Supplier> loadSuppliers();
    void saveTransactions(List<Transaction> transactions);
    List<Transaction> loadTransactions();
}
