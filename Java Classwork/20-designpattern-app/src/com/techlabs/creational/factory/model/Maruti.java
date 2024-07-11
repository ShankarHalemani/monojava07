package com.techlabs.creational.factory.model;

public class Maruti implements ICar{
    @Override
    public void start() {
        System.out.println("Maruti Car started");
    }

    @Override
    public void stop() {
        System.out.println("Maruti Car stopped");
    }
}
