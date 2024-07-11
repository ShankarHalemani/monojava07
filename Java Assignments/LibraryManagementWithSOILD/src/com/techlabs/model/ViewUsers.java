package com.techlabs.model;

public class ViewUsers {
    private User user;

    public ViewUsers(User user) {
        this.user = user;
    }

    public void viewUser() {
        System.out.println("User name : " + user.getUserName());
        System.out.println("User ID : " + user.getUserId());
    }
}