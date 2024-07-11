package com.techlabs.strcutural.facade.model;

public class ItalianMenu implements IMenu{
    @Override
    public void displayMenu() {
        System.out.println("Appetizers:");
        System.out.println("1. Bruschetta: Grilled bread topped with tomatoes, garlic, basil, and olive oil.");
        System.out.println("2. Caprese Salad: Sliced fresh mozzarella, tomatoes, and basil, seasoned with salt and olive oil.");
        System.out.println("3. Arancini: Deep-fried rice balls stuffed with cheese, meat, or vegetables.");

        System.out.println("\nMain Courses:");
        System.out.println("1. Margherita Pizza: Classic pizza with tomatoes, mozzarella cheese, fresh basil, salt, and olive oil.");
        System.out.println("2. Lasagna: Layered pasta with meat or vegetables, cheese, and tomato sauce, baked to perfection.");
        System.out.println("3. Spaghetti Carbonara: Pasta with eggs, cheese, pancetta, and pepper.");
        System.out.println("4. Risotto: Creamy rice dish cooked with broth, often containing mushrooms, seafood, or saffron.");
    }
}
