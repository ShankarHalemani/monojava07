package com.techlabs.creational.abstractFactory.model;

public class Maruti implements ICars{
    @Override
    public void start() {
        System.out.println("Maruti car started");
    }

    @Override
    public void stop() {
        System.out.println("Maruti car stopped");
    }
}
