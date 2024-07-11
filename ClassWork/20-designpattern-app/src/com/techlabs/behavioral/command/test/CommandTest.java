package com.techlabs.behavioral.command.test;

import com.techlabs.behavioral.command.model.*;

public class CommandTest {
    public static void main(String[] args) {
        Television television = new Television();

        ICommand onCommand = new OnCommand(television);
        RemoteControl remoteControl = new RemoteControl(onCommand);
        remoteControl.pressButton();

        ICommand offCommand = new OffCommand(television);
        remoteControl.setCommand(offCommand);
        remoteControl.pressButton();
    }
}
