package com.techlabs.behavioral.state.model;

public class OffState implements IState{

    private Phone phone;

    public OffState(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String onHome() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }

    @Override
    public String onOffOn() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }
}
