package com.techlabs.model;

public class CatalogBook implements ICatalog {

    @Override
    public void catalogBook(Book book) {
        System.out.println("Book Name : " + book.getTitle() + " , Book Author : " + book.getAuthor());
        System.out.println("Book Type : " + book.getBookType());
        if (book.isBorrowed()) {
            System.out.println("Book is not Available to borrow");
            return;
        }
        System.out.println("Book is Available to borrow");
    }
}
