package com.techlabs.strcutural.facade.model;

public class ItalianHotel implements IHotel{
    @Override
    public IMenu getMenu() {
        return new ItalianMenu();
    }
}
