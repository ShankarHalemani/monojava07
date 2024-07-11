package com.techlabs.behavioral.state.model;

public class LockedState implements IState{
    private Phone phone;

    public LockedState(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String onHome() {
        phone.setState(new ReadyState(phone));
        return phone.unlock();
    }

    @Override
    public String onOffOn() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
