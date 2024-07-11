package com.techlabs.model;

public class BorrowBook implements IBorrow {

    @Override
    public void borrowBook(User user, Book book) {
        book.setBorrowed(true);
        System.out.println("Book and Borrower Details");
        System.out.println("User ID : " + user.getUserId() + " , User Name : " + user.getUserName());
        System.out.println("Book Title : " + book.getTitle() + " , Book Author : " + book.getAuthor());
    }
}