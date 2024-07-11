package com.techlabs.model;

public class ReturnBook implements IReturn {

    @Override
    public void returnBook(User user, Book book) {
        book.setBorrowed(false);
        System.out.println("User " + user.getUserName() + " has returned " + book.getTitle());
    }
}