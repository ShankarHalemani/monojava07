package com.techlabs.behavioral.observer.test;

import com.techlabs.behavioral.observer.exceptions.NotifierAlreadyExistException;
import com.techlabs.behavioral.observer.exceptions.NotifierDoestNotExistException;
import com.techlabs.behavioral.observer.model.Account;
import com.techlabs.behavioral.observer.model.EmailNotifier;
import com.techlabs.behavioral.observer.model.SMSNotifier;

public class ObserverTest {
    public static void main(String[] args) {

//        Singleton object for EmailNotifier(),SMSNotifier() and add in List if not present

        try {
            Account account1 = new Account(00001, "Shankar", 20000);
            System.out.println(account1+"\n");
            account1.registerNotifier(EmailNotifier.getInstance());
            account1.registerNotifier(SMSNotifier.getInstance());
            account1.deregisterNotifier(SMSNotifier.getInstance());
//            account1.deregisterNotifier(SMSNotifier.getInstance());
            account1.withdrawAmount(2000);
            System.out.println(account1);


            Account account2 = new Account(00002, "Fayaz", 30000);
            System.out.println(account2+"\n");
            account2.registerNotifier(EmailNotifier.getInstance());
            account2.registerNotifier(SMSNotifier.getInstance());
//            account2.registerNotifier(EmailNotifier.getInstance());
            account2.depositAmount(3000);
            System.out.println(account2);
        }

        catch (NotifierAlreadyExistException e){
            System.out.println(e.getMessage());
        }

        catch (NotifierDoestNotExistException e){
            System.out.println(e.getMessage());
        }


    }
}
