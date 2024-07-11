package com.techlabs.behavioral.command.model;

public class OffCommand implements ICommand {
    private Television television;

    public OffCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.Off();
    }
}
