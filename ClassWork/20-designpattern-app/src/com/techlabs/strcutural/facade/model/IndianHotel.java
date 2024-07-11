package com.techlabs.strcutural.facade.model;

public class IndianHotel implements IHotel{
    @Override
    public IMenu getMenu() {
        return new IndianMenu();
    }
}
