package com.techlabs.strcutural.decorator.model;

public abstract class CarServiceDecorator implements ICarService{
    private ICarService carService;

    public CarServiceDecorator(ICarService carService) {
        this.carService = carService;
    }

    @Override
    public double getCost() {
        return carService.getCost();
    }
}
