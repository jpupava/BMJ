package com.example.demo;

public class Borrowing {

    private int borrowingId;
    private int customerId;
    private int bookId;
    private String customerName;
    private String authorName;
    private String title;

    public void setBorrowingId(int borrowingId) {
        this.borrowingId = borrowingId;
    }

    public int getBorrowingId() {
        return borrowingId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId(){
        return bookId;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorName(){
        return authorName;
    }
    public void setTitle(String setTitle) {
        this.title = setTitle;
    }
    public String getTitle(){
        return title;
    }

}
