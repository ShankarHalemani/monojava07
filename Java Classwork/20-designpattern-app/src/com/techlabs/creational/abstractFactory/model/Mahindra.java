package com.techlabs.creational.abstractFactory.model;

public class Mahindra implements ICars{
    @Override
    public void start() {
        System.out.println("Mahindra car started");
    }

    @Override
    public void stop() {
        System.out.println("Mahindra car stopped");
    }
}
