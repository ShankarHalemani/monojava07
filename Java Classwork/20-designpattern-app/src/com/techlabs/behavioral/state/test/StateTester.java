package com.techlabs.behavioral.state.test;

import com.techlabs.behavioral.state.model.Phone;

public class StateTester {
    public static void main(String[] args) {
        Phone phone = new Phone(); // At the beginning phone is in off state
        simulatePhoneClicks(phone);
    }

    private static void simulatePhoneClicks(Phone phone) {
        System.out.println(phone.clickPower()); // Turning screen on, device still locked
        System.out.println(phone.clickHome());  // Unlocking the phone to home
        System.out.println(phone.clickHome());  // Going to home-screen
        System.out.println(phone.clickPower()); // Locking phone and turning off the screen
        System.out.println(phone.clickPower()); // Turning screen on, device still locked
    }
}
