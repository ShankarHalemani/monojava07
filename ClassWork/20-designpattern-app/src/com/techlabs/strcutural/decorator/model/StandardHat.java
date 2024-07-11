package com.techlabs.strcutural.decorator.model;

public class StandardHat implements IHat{

    private String hatName;
    private double hatPrice;
    private String hatDescription;

    public StandardHat(String hatName, double hatPrice, String hatDescription) {
        this.hatName = hatName;
        this.hatPrice = hatPrice;
        this.hatDescription = hatDescription;
    }

    @Override
    public String getHatName() {
        return hatName;
    }

    @Override
    public double getHatPrice() {
        return hatPrice;
    }

    @Override
    public String getHatDescription() {
        return hatDescription;
    }
}
