package com.techlabs.strcutural.adapter.model;

public class AdapterHat implements IItems {
    private Hat hat;

    public AdapterHat(Hat hat) {
        this.hat = hat;
    }

    @Override
    public String getItemName() {
        return hat.getLongName()+" "+hat.getShortName();
    }

    @Override
    public int getItemPrice() {
        return hat.getBasePrice()+hat.getTaxPrice();
    }
}
