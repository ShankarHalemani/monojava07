package com.techlabs.strcutural.decorator.model;

public class WheelAlign extends CarServiceDecorator{

    public WheelAlign(ICarService carService) {
        super(carService);
    }

    @Override
    public double getCost() {
        return 400+super.getCost();
    }
}
