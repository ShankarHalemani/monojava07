package com.techlabs.strcutural.adapter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
//    private Biscuit biscuit;
//    private Chocolate chocolate;
//    private Hat hat;
//    private AdapterHat adapterHat;
    private List<IItems> cart = null;

    public ShoppingCart() {
//        this.biscuit = biscuit;
//        this.chocolate = chocolate;
//        this.hat = hat;
//        this.adapterHat = new AdapterHat(hat);
        cart = new ArrayList<IItems>();

    }

    public void addItemsToCart(IItems object){
        cart.add(object);
    }

    public List<String> getCartItems(){
        List<String> itemNames = cart.stream().map((item)->item.getItemName()).collect(Collectors.toList());
        return itemNames;
    }

    public List<Integer> getCartPrice(){
        List<Integer> itemPrice = cart.stream().map((item)->item.getItemPrice()).collect(Collectors.toList());
        return itemPrice;
    }

    public void displayItems(){
        System.out.println("Item Name \t  Price");
        List<String> items = getCartItems();
        List<Integer> prices = getCartPrice();

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + "\t" + prices.get(i));
        }
        int totalPrice = getCartPrice().stream().reduce(0,(sum,item)->sum+item);
        System.out.println("Total Price : "+totalPrice);
    }




}
