package com.techlabs.behavioral.state.model;

public class ReadyState implements IState{

    private Phone phone;

    public ReadyState(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String onHome() {
        return phone.home();
    }

    @Override
    public String onOffOn() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
