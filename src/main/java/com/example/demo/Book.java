package com.example.demo;

public class Book {
    private Long id;
    private String authorFirstname;
    private String authorLastname;
    private String title;
    private String isbn;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getauthorFirstname() {
        return authorFirstname;
    }

    public void setauthorFirstname(String firstName) {
        this.authorFirstname = authorFirstname;
    }

    public String getauthorLastname() {
        return authorLastname;
    }

    public void setauthorLastname(String lastName) {
        this.authorLastname = authorLastname;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public int getcount() {
        return count;
    }

    public void setcount(int count) {
        this.count = count;
    }
}
