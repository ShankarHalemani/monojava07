package com.techlabs.model;

import com.techlabs.exceptions.InvalidProductIdException;

import java.util.Date;
import java.util.List;

public class AddStock implements TransactionType{
    private ProductManager productManager;
    private TransactionManager transactionManager;
    private UIDGenerator uidGenerator;

    public AddStock(ProductManager productManager, TransactionManager transactionManager) {
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
        product.setProductQuantity(product.getProductQuantity()+productQuantity);
        Transaction transaction = new Transaction(uidGenerator.generateTransactionId(),productId,"add",productQuantity, new Date());
        transactionManager.recordTransaction(transaction);
    }
}
