package com.techlabs.strcutural.decorator.model;

public class OilChange extends CarServiceDecorator{

    public OilChange(ICarService carService) {
        super(carService);
    }

    @Override
    public double getCost() {
        return 500+super.getCost();
    }
}
