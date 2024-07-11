package com.techlabs.model;

import com.techlabs.exceptions.InsufficientStockException;
import com.techlabs.exceptions.InvalidProductIdException;

import java.util.Date;

public class RemoveStock implements TransactionType{
    private ProductManager productManager;
    private TransactionManager transactionManager;
    private UIDGenerator uidGenerator;

    public RemoveStock(ProductManager productManager, TransactionManager transactionManager) {
        this.productManager = productManager;
        this.transactionManager = transactionManager;
        this.uidGenerator = new UIDGenerator();
    }

    @Override
    public void execute(String productId, int productQuantity) {
        Product product = productManager.getProduct(productId);
        if(product==null){
            throw new InvalidProductIdException("Product ID "+productId+" is invalid");
        }
        if(product.getProductQuantity()<productQuantity){
            throw new InsufficientStockException("Insufficient stock for Product ID : "+productId);
        }
        product.setProductQuantity(product.getProductQuantity()-productQuantity);
        Transaction transaction = new Transaction(uidGenerator.generateTransactionId(),productId,"remove",productQuantity, new Date());
        transactionManager.recordTransaction(transaction);
    }
}
