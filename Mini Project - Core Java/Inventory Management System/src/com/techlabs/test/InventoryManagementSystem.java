package com.techlabs.test;

import com.techlabs.model.*;
import com.techlabs.exceptions.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InventoryManagementSystem {
    private static ProductManager productManager = new ProductManager();
    private static SupplierManager supplierManager = new SupplierManager();
    private static TransactionManager transactionManager = new TransactionManager();
    private static DataPersistance dataManager = new DataManager();
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            displayMenu();
            handleUserInput();
        }

    }

    private static void displayMenu() {
        System.out.println("Welcome to the Inventory Management System");
        System.out.println("1. Product Management");
        System.out.println("2. Supplier Management");
        System.out.println("3. Transaction Management");
        System.out.println("4. Save Data");
        System.out.println("5. Load Data");
        System.out.println("6. Generate Reports");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleUserInput() {
        int choose = scanner.nextInt();
        scanner.nextLine();
        executionOption(choose);
    }

    private static void executionOption(int choose) {
        switch (choose){
            case 1 :
                productOperations();
                break;

            case 2 :
                supplierOperations();
                break;

            case 3 :
                transactionOperations();
                break;

            case 4 :
                saveData();
                break;

            case 5 :
                loadData();
                break;

            case 6 :
                reportGeneration();
                break;

            case 7 :
                executorService.shutdownNow();
                scanner.close();
                System.exit(0);
                break;
        }
    }

    private static void productOperations() {
        while (true) {
            System.out.println("Product Management");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product Details");
            System.out.println("5. View All Products");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            try {
                switch (choice) {
                    case 1:
                        UIDGenerator uidGenerator = new UIDGenerator();
                        System.out.println();
                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Product Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter Product Quantity: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Enter Product Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // consume newline character

                        Product product = new Product(uidGenerator.generateProductId(), name, description, quantity, price);
                        productManager.addProduct(product);
                        System.out.println("Product added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter Product ID: ");
                        String productId = scanner.nextLine();
                        Product existingProduct = productManager.getProduct(productId);
                        if (existingProduct != null) {
                            System.out.print("Enter New Product Name: ");
                            name = scanner.nextLine();
                            System.out.print("Enter New Product Description: ");
                            description = scanner.nextLine();
                            System.out.print("Enter New Product Quantity: ");
                            quantity = scanner.nextInt();
                            System.out.print("Enter New Product Price: ");
                            price = scanner.nextDouble();
                            scanner.nextLine(); // consume newline character

                            existingProduct.setProductName(name);
                            existingProduct.setProductDescription(description);
                            existingProduct.setProductQuantity(quantity);
                            existingProduct.setProductPrice(price);
                            productManager.updateProduct(existingProduct);
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;
                    case 3:
                        System.out.println();
                        System.out.print("Enter Product ID: ");
                        productId = scanner.nextLine();
                        productManager.deleteProduct(productId);
                        System.out.println("Product deleted successfully.");
                        break;
                    case 4:
                        System.out.println();
                        System.out.print("Enter Product ID: ");
                        productId = scanner.nextLine();
                        existingProduct = productManager.getProduct(productId);
                        if (existingProduct != null) {
                            System.out.println("Product Details:");
                            System.out.println(existingProduct);
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;
                    case 5:
                        List<Product> products = productManager.getAllProducts();
                        System.out.println("All Products:");
                        for (Product p : products) {
                            System.out.println(p);
                        }
                        break;
                    case 6:
                        return; // Exit to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            catch (InvalidProductIdException | InsufficientStockException | DuplicateProductException e) {
                System.out.println("Error: " + e.getMessage());
            }

            catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

    }


    private static void supplierOperations() {
        while (true) {
            System.out.println("Supplier Management");
            System.out.println("1. Add Supplier");
            System.out.println("2. Update Supplier");
            System.out.println("3. Delete Supplier");
            System.out.println("4. View Supplier Details");
            System.out.println("5. View All Suppliers");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            try {
                switch (choice) {
                    case 1:
                        UIDGenerator uidGenerator = new UIDGenerator();
                        System.out.println();
                        System.out.print("Enter Supplier Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Supplier Contact Information: ");
                        String contactInfo = scanner.nextLine();

                        Supplier supplier = new Supplier(uidGenerator.generateSupplierId(), name, contactInfo);
                        supplierManager.addSupplier(supplier);
                        System.out.println("Supplier added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter Supplier ID: ");
                        String supplierId = scanner.nextLine();
                        Supplier existingSupplier = supplierManager.getSupplier(supplierId);
                        if (existingSupplier != null) {
                            System.out.print("Enter New Supplier Name: ");
                            name = scanner.nextLine();
                            System.out.print("Enter New Supplier Contact Information: ");
                            contactInfo = scanner.nextLine();

                            existingSupplier.setSupplierName(name);
                            existingSupplier.setSupplierContactInfo(contactInfo);
                            supplierManager.updateSupplier(existingSupplier);
                            System.out.println("Supplier updated successfully.");
                        } else {
                            System.out.println("Supplier not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Supplier ID: ");
                        supplierId = scanner.nextLine();
                        supplierManager.deleteSupplier(supplierId);
                        System.out.println("Supplier deleted successfully.");
                        break;
                    case 4:
                        System.out.print("Enter Supplier ID: ");
                        supplierId = scanner.nextLine();
                        existingSupplier = supplierManager.getSupplier(supplierId);
                        if (existingSupplier != null) {
                            System.out.println("Supplier Details:");
                            System.out.println(existingSupplier);
                        } else {
                            System.out.println("Supplier not found.");
                        }
                        break;
                    case 5:
                        List<Supplier> suppliers = supplierManager.getAllSuppliers();
                        System.out.println("All Suppliers:");
                        for (Supplier s : suppliers) {
                            System.out.println(s);
                        }
                        break;
                    case 6:
                        return; // Exit to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            catch (InvalidSupplierIdException | DuplicateSupplierException e) {
                System.out.println("Error: " + e.getMessage());
            }

            catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void transactionOperations() {
        while (true) {
            try {
                System.out.println("1. Add Stock");
                System.out.println("2. Remove Stock");
                System.out.println("3. View Transaction History for a Product");
                System.out.println("4. View Transaction History for All Products");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter Product ID: ");
                        String productIdToAdd = scanner.nextLine();
                        System.out.print("Enter Quantity to Add: ");
                        int quantityToAdd = scanner.nextInt();
                        executorService.submit(() -> {
                            try {
                                TransactionType addStock = new AddStock(productManager, transactionManager);
                                addStock.execute(productIdToAdd, quantityToAdd);
                                System.out.println("Stock added successfully.");
                            } catch (InvalidProductIdException | InsufficientStockException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        });
                        break;
                    case 2:
                        System.out.print("Enter Product ID: ");
                        String productIdToRemove = scanner.nextLine();
                        System.out.print("Enter Quantity to Remove: ");
                        int quantityToRemove = scanner.nextInt();
                        executorService.submit(() -> {
                            try {
                                TransactionType removeStock = new RemoveStock(productManager, transactionManager);
                                removeStock.execute(productIdToRemove, quantityToRemove);
                                System.out.println("Stock removed successfully.");
                            } catch (InvalidProductIdException | InsufficientStockException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        });
                        break;
                    case 3:
                        System.out.print("Enter Product ID to view transaction history: ");
                        String productId = scanner.nextLine();
                        executorService.submit(() -> {
                            List<Transaction> transactions = transactionManager.getTransactionHistory(productId);
                            System.out.println("Transaction History for Product ID " + productId + ":");
                            for (Transaction t : transactions) {
                                System.out.println(t);
                            }
                        });
                        break;
                    case 4:
                        executorService.submit(() -> {
                            List<Transaction> transactions = transactionManager.getAllTransactions();
                            System.out.println("Transaction History for All Products:");
                            for (Transaction t : transactions) {
                                System.out.println(t);
                            }
                        });
                        break;
                    case 5:
                        return; // Exit to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }


    private static void saveData() {
        executorService.submit(() -> {
            try {
                dataManager.saveProducts(productManager.getAllProducts());
                dataManager.saveSuppliers(supplierManager.getAllSuppliers());
                dataManager.saveTransactions(transactionManager.getAllTransactions());
                System.out.println("Data saved successfully.");
            }

            catch (DataPersistenceException e) {
                System.out.println("Error saving data: " + e.getMessage());
            }
        });
    }

    private static void loadData() {
        executorService.submit(() -> {
            try {
                List<Product> products = dataManager.loadProducts();
                for (Product product : products) {
                    productManager.addProduct(product);
                }

                List<Supplier> suppliers = dataManager.loadSuppliers();
                for (Supplier supplier : suppliers) {
                    supplierManager.addSupplier(supplier);
                }

                List<Transaction> transactions = dataManager.loadTransactions();
                for (Transaction transaction : transactions) {
                    transactionManager.recordTransaction(transaction);
                }
                System.out.println("Data loaded successfully.");
            }

            catch (DataPersistenceException | DuplicateProductException | DuplicateSupplierException e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        });
    }

    private static void reportGeneration() {
        ReportGenerator reportGenerator = new ReportGenerator(productManager,supplierManager,transactionManager);
        System.out.println("Product Report:");
        System.out.println(reportGenerator.productReportGenerator());
        System.out.println("Supplier Report:");
        System.out.println(reportGenerator.supplierReportGenerator());
        System.out.println("Transaction Report:");
        System.out.println(reportGenerator.transactionReportGenerator());
    }
}
