package com.techlabs.strcutural.decorator.model;

public class GoldenHat extends HatDecorator {

    public GoldenHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getHatName() {
        return "Golden"+super.getHatName();
    }

    @Override
    public double getHatPrice() {
        return 100+super.getHatPrice();
    }

    @Override
    public String getHatDescription() {
        return super.getHatDescription()+" and Its Golden Hat";
    }
}
