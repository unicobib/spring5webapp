package com.unicobib.spring5webapp.domain;

import java.util.Set;

public class Book {

    private String bookName;
    private Set<Author> authors;

    public Book() {

    }

    public Book(String bookName, Set<Author> authors) {
        this.bookName = bookName;
        this.authors = authors;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
