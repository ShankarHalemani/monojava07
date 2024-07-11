package com.techlabs.strcutural.adapter.model;

public class Hat {
    private String shortName;
    private String longName;
    private int basePrice;
    private int taxPrice;

    public Hat(String shortName, String longName, int basePrice, int taxPrice) {
        this.shortName = shortName;
        this.longName = longName;
        this.basePrice = basePrice;
        this.taxPrice = taxPrice;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(int taxPrice) {
        this.taxPrice = taxPrice;
    }
}
