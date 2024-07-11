package com.techlabs.behavioral.strategy.model;

public class OperationStrategy implements IOperation{
    private IOperation operation;

    public OperationStrategy(IOperation operation) {
        this.operation = operation;
    }

    @Override
    public int doOperation(int a, int b) {
        return this.operation.doOperation(a,b);
    }

    public void setOperation(IOperation operation){
        this.operation=operation;
    }

}
