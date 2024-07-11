package com.techlabs.creational.singleton.model;

public class Login {
//    private static Login login = new Login(); //eager loading
    private static Login login;
    private Login(){}

    public static Login getLogin(){
        if(login==null)
            login=new Login();
        return login;
    }

    public String getMessage(){
        return "Login Successful";
    }

}
