package com.techlabs.model;

import java.util.List;

public class ReportGenerator {
    private ProductManager productManager;
    private SupplierManager supplierManager;
    private TransactionManager transactionManager;
    private List<Product> products;
    private List<Supplier> suppliers;
    private List<Transaction> transactions;

    public ReportGenerator(ProductManager productManager, SupplierManager supplierManager, TransactionManager transactionManager) {
        this.productManager = productManager;
        this.supplierManager = supplierManager;
        this.transactionManager = transactionManager;
        this.products = productManager.getAllProducts();
        this.suppliers = supplierManager.getAllSuppliers();
        this.transactions = transactionManager.getAllTransactions();
    }

    public String productReportGenerator(){
        StringBuilder report = new StringBuilder();
        for(Product product : products){
            report.append(product.toString()).append("\n");
        }
        return report.toString();
    }

    public String supplierReportGenerator(){
        StringBuilder report = new StringBuilder();
        for(Supplier supplier : suppliers){
            report.append(supplier.toString()).append("\n");
        }
        return report.toString();
    }

    public String transactionReportGenerator(){
        StringBuilder report = new StringBuilder();
        for(Transaction transaction : transactions){
            report.append(transaction.toString()).append("\n");
        }
        return report.toString();
    }
}
