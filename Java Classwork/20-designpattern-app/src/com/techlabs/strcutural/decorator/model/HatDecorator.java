package com.techlabs.strcutural.decorator.model;

public abstract class HatDecorator implements IHat{
    private IHat hat;

    public HatDecorator(IHat hat) {
        this.hat = hat;
    }

    @Override
    public String getHatName() {
        return hat.getHatName();
    }

    @Override
    public double getHatPrice() {
        return hat.getHatPrice();
    }

    @Override
    public String getHatDescription() {
        return hat.getHatDescription();
    }
}
