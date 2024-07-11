package com.techlabs.behavioral.observer.model;

public interface INotifier {
    void notifyUser(Account account, int amount, String transaction);
}
