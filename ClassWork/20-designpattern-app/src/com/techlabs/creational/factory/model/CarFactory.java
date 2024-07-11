package com.techlabs.creational.factory.model;

public class CarFactory {
    private static ICar car;

    public static ICar getCar(String carName){
        if(carName=="Maruti")
            car = new Maruti();

        if (carName=="Mahindra")
            car=new Mahindra();

        if(carName=="Tata")
            car=new Tata();

        return car;
    }

}
