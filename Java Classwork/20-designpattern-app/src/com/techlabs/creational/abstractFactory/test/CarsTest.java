package com.techlabs.creational.abstractFactory.test;

import com.techlabs.creational.abstractFactory.model.*;

public class CarsTest {
    public static void main(String[] args) {
        IFactory marutiFactory = new MarutiFactory();
        ICars maruti = marutiFactory.makeCar();
        maruti.start();
        maruti.stop();

        IFactory mahindraFactory = new MahindraFactory();
        ICars mahindra = mahindraFactory.makeCar();
        mahindra.start();
        mahindra.stop();

        IFactory tataFactory = new TataFactory();
        ICars tata = tataFactory.makeCar();
        tata.start();
        tata.stop();
    }
}
