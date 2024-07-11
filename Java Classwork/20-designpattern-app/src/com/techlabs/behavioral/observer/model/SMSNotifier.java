package com.techlabs.behavioral.observer.model;

public class SMSNotifier implements INotifier{
//    created singleton object
    private static SMSNotifier smsNotifier;

    private SMSNotifier(){}

    public static SMSNotifier getInstance(){
        if(smsNotifier==null)
            smsNotifier=new SMSNotifier();
        return smsNotifier;
    }


    @Override
    public void notifyUser(Account account, int amount, String transaction) {

        System.out.println(transaction+" transaction of amount : "+amount);
        System.out.println("SMS Notification for Account number : "+account.getAccountNumber());
        System.out.println("Current Account Balance : "+account.getAccountBalance());
        System.out.println("------------------------------------------------------------------------");
    }
}
