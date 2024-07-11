package com.techlabs.strcutural.decorator.model;

public class RibbonHat extends HatDecorator{

    public RibbonHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getHatName() {
        return super.getHatName();
    }

    @Override
    public double getHatPrice() {
        return 200+super.getHatPrice();
    }

    @Override
    public String getHatDescription() {
        return super.getHatDescription()+" and its Ribbon hat";
    }
}
