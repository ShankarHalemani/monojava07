package com.techlabs.creational.abstractFactory.model;

public class TataFactory implements IFactory{
    @Override
    public ICars makeCar() {
        return new Tata();
    }
}
