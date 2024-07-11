package com.techlabs.creational.factory.model;

public interface IAccount {
    void credit(int amount);
    void debit(int amount);
    void displayAccountDetails();
}
