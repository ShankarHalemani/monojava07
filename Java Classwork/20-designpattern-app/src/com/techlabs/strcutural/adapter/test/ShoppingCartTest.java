package com.techlabs.strcutural.adapter.test;

import com.techlabs.strcutural.adapter.model.*;

public class ShoppingCartTest {
    public static void main(String[] args) {
        IItems biscuit = new Biscuit("Parle-G",20);
        IItems chocolate = new Chocolate("Dairy Milk",50);
        Hat hat = new Hat("Hat","Peter England",300,20);
        IItems adapterHat = new AdapterHat(hat);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItemsToCart(biscuit);
        shoppingCart.addItemsToCart(chocolate);
        shoppingCart.addItemsToCart(adapterHat);

        shoppingCart.displayItems();
    }
}
