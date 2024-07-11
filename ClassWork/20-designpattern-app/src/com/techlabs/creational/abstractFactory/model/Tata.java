package com.techlabs.creational.abstractFactory.model;

public class Tata implements ICars{
    @Override
    public void start() {
        System.out.println("Tata car started");
    }

    @Override
    public void stop() {
        System.out.println("Tata car stopped");
    }
}
