package com.techlabs.creational.factory.model;

import java.util.Scanner;

public class AccountFactory {
    private static IAccount account;

    public static IAccount getAccount(int accountNumber, String accountName, int accountBalance){
            account = new SavingsAccount(accountNumber, accountName, accountBalance);
            return account;
    }

    public static IAccount getAccount(int accountNumber,int accountBalance, int overdraftLimit){
        account = new CurrentAccount(accountNumber, accountBalance, overdraftLimit);
        return account;
    }

}
