package com.techlabs.creational.abstractFactory.model;

public class MahindraFactory implements IFactory{
    @Override
    public ICars makeCar() {
        return new Mahindra();
    }
}
