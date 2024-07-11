package com.techlabs.strcutural.facade.model;

public class IndianMenu implements IMenu{
    @Override
    public void displayMenu() {
        System.out.println("Appetizers:");
        System.out.println("1. Samosa: Deep-fried pastry filled with spiced potatoes, peas, and sometimes meat.");
        System.out.println("2. Pakora: Deep-fried fritters made with vegetables or chicken, coated in a spiced chickpea flour batter.");
        System.out.println("3. Pani Puri: Hollow, crispy puris filled with spicy tamarind water, chickpeas, and potatoes.");

        System.out.println("\nMain Courses:");
        System.out.println("1. Butter Chicken (Murgh Makhani): Chicken cooked in a creamy tomato-based sauce with butter and spices.");
        System.out.println("2. Paneer Butter Masala: Paneer (Indian cottage cheese) cubes cooked in a rich, creamy tomato gravy.");
        System.out.println("3. Chole Bhature: Spicy chickpeas (chole) served with deep-fried bread (bhature).");
        System.out.println("4. Biryani: Spiced rice dish cooked with marinated meat or vegetables.");
    }
}
