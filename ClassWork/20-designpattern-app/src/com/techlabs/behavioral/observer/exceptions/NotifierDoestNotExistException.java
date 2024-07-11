package com.techlabs.behavioral.observer.exceptions;

public class NotifierDoestNotExistException extends RuntimeException {
    public NotifierDoestNotExistException(String notifier){
        super(notifier+" does not exist for this account");
    }
}
