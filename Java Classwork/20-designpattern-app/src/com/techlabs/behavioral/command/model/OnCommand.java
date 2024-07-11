package com.techlabs.behavioral.command.model;

public class OnCommand implements ICommand {
    private Television television;

    public OnCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.On();
    }
}
