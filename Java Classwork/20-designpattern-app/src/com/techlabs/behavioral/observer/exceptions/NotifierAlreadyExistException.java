package com.techlabs.behavioral.observer.exceptions;

public class NotifierAlreadyExistException extends RuntimeException{
    public NotifierAlreadyExistException(String notifierName){
        super(notifierName+" already exist for this account");
    }
}
