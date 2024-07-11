package com.techlabs.creational.factory.test;

import com.techlabs.creational.factory.model.*;

public class CarTest {
    public static void main(String[] args) {
        ICar car;

        car = CarFactory.getCar("Maruti");
        car.start();
        car.stop();

        car = CarFactory.getCar("Mahindra");
        car.start();
        car.stop();

        car = CarFactory.getCar("Tata");
        car.start();
        car.stop();
    }
}
