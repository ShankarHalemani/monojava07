package com.techlabs.model;

public class EBook extends Book {

    public EBook(String title, String author, boolean isBorrowed) {
        super(title, author, isBorrowed);
    }

    @Override
    public String getBookType() {
        return "E Book";
    }
}