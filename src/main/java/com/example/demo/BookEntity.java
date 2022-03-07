package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue
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

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
