package com.techlabs.strcutural.facade.model;

public class HotelReception {
    public void getIndianMenu(){
        IHotel indianHotel = new IndianHotel();
        IMenu indianMenu= indianHotel.getMenu();
        indianMenu.displayMenu();
    }

    public void getItalianMenu(){
        IHotel italianHotel = new ItalianHotel();
        IMenu italianMenu= italianHotel.getMenu();
        italianMenu.displayMenu();
    }
}
