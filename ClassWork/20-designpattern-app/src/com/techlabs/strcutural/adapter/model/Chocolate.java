package com.techlabs.strcutural.adapter.model;

public class Chocolate implements IItems{
    private String name;
    private int maxRetailPrice;

    public Chocolate(String name, int maxRetailPrice) {
        this.name = name;
        this.maxRetailPrice = maxRetailPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(int maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    @Override
    public String getItemName() {
        return this.getName();
    }

    @Override
    public int getItemPrice() {
        return this.getMaxRetailPrice();
    }
}
