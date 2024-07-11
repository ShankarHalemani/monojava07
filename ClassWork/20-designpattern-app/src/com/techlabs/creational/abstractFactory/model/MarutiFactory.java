package com.techlabs.creational.abstractFactory.model;

public class MarutiFactory implements IFactory{
    @Override
    public ICars makeCar() {
        return new Maruti();
    }
}
