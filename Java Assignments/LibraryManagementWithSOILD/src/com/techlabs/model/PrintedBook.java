package com.techlabs.model;

public class PrintedBook extends Book {

    public PrintedBook(String title, String author, boolean isBorrowed) {
        super(title, author, isBorrowed);
    }

    @Override
    public String getBookType() {
        return "Printed Book";
    }
}