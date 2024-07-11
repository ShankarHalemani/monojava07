package com.techlabs.strcutural.decorator.test;

import com.techlabs.strcutural.decorator.model.CarInspection;
import com.techlabs.strcutural.decorator.model.OilChange;
import com.techlabs.strcutural.decorator.model.WheelAlign;

public class CarServiceDecoratorTest {
    public static void main(String[] args) {

        CarInspection carInspection = new CarInspection();
        System.out.println("Car Inspection : "+carInspection.getCost());

        System.out.println("-----------------------------------------------------");

        OilChange carInspectionOilChange = new OilChange(carInspection);
        System.out.println("Car Inspection with Oil change : "+carInspectionOilChange.getCost());

        System.out.println("-----------------------------------------------------");

        WheelAlign carInspectionOilChangeWheelAlign = new WheelAlign(carInspectionOilChange);
        System.out.println("Car Inspection with Oil change and Wheel Align : "+carInspectionOilChangeWheelAlign.getCost());

        System.out.println("-----------------------------------------------------");
    }
}
