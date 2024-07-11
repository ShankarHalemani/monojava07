package com.techlabs.creational.factory.model;

public class CurrentAccount implements IAccount{
    private int accountNumber;
    private int accontBalance;
    private int overdraftLimit;

    public CurrentAccount(int accountNumber, int accontBalance, int overdraftLimit) {
        this.accountNumber = accountNumber;
        this.accontBalance = accontBalance;
        this.overdraftLimit = overdraftLimit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccontBalance() {
        return accontBalance;
    }

    public void setAccontBalance(int accontBalance) {
        this.accontBalance = accontBalance;
    }

    public int getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void credit(int amount) {
        this.accontBalance+=amount;

    }

    @Override
    public void debit(int amount) {
        if(this.accontBalance+this.overdraftLimit>=amount)
            this.accontBalance-=amount;
        System.out.println("Overdraft Limit reached");
    }

    @Override
    public void displayAccountDetails() {
        System.out.println();
        System.out.println("Account Number : "+getAccountNumber());
        System.out.println("Account Balance : "+getAccontBalance());
        System.out.println("Account overdraft limit : "+getOverdraftLimit());
        System.out.println();
    }
}
