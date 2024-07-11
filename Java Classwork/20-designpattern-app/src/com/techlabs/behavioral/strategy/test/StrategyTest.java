package com.techlabs.behavioral.strategy.test;

import com.techlabs.behavioral.strategy.model.AddOperation;
import com.techlabs.behavioral.strategy.model.MultiplyOperation;
import com.techlabs.behavioral.strategy.model.OperationStrategy;

public class StrategyTest {
    public static void main(String[] args) {
        OperationStrategy operation1 = new OperationStrategy(new AddOperation());
        System.out.println("\nAddition Operation : "+operation1.doOperation(30,40));
        System.out.println();

        OperationStrategy operation2 = new OperationStrategy(new MultiplyOperation());
        System.out.println("Multiplication Operation : "+operation2.doOperation(20,40));
        System.out.println();

        operation2.setOperation(new AddOperation());
        System.out.println("Addition Operation : "+operation2.doOperation(10,20));
    }
}
