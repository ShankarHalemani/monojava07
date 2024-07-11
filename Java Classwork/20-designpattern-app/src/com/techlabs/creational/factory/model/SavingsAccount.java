package com.techlabs.creational.factory.model;

public class SavingsAccount implements IAccount{
    private int accountNUmber;
    private String accountName;
    private int accountBalance;

    public SavingsAccount(int accountNUmber, String accountName, int accountBalance) {
        this.accountNUmber = accountNUmber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public int getAccountNUmber() {
        return accountNUmber;
    }

    public void setAccountNUmber(int accountNUmber) {
        this.accountNUmber = accountNUmber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public void credit(int amount) {
        this.accountBalance+=amount;
    }

    @Override
    public void debit(int amount) {
        if(this.accountBalance>=amount)
            this.accountBalance-=amount;

        System.out.println("Insufficiant Balance");
    }



    @Override
    public void displayAccountDetails() {
        System.out.println();
        System.out.println("Account Holder Name : "+getAccountName());
        System.out.println("Account Number : "+getAccountNUmber());
        System.out.println("Account Balance : "+getAccountBalance());
        System.out.println();
    }
}
