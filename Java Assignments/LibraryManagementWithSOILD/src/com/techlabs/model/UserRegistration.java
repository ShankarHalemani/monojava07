package com.techlabs.model;

public class UserRegistration {
    private User user;

    public UserRegistration(User user) {
        this.user = user;
    }

    public void registerUser() {
        System.out.println("User Registered");
        System.out.println("User Name : " + user.getUserName() + " User Id : " + user.getUserId());
    }
}
