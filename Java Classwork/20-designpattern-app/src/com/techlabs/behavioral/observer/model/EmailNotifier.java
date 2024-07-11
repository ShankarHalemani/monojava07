package com.techlabs.behavioral.observer.model;

public class EmailNotifier implements INotifier{
//    created singleton object
    private static EmailNotifier emailNotifier;

    private EmailNotifier(){}

    public static EmailNotifier getInstance(){
        if(emailNotifier==null)
            emailNotifier=new EmailNotifier();
        return emailNotifier;
    }

    @Override
    public void notifyUser(Account account, int amount, String transaction) {

        System.out.println(transaction+" transaction of amount : "+amount);
        System.out.println("Email Notification for Account number : "+account.getAccountNumber());
        System.out.println("Current Account Balance : "+account.getAccountBalance());
        System.out.println("------------------------------------------------------------------------");
    }
}
