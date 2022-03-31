package com.example.demo;

public class BorrowingDto {

    private Long borrowingId;
    private Long customerId;
    private Long bookId;

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }
    public long getBorrowingId() {
        return borrowingId;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }
    public Long getCustomerId(){
        return this.customerId;
    }

    public void setBookId(Long bookId){
        this.bookId = bookId;
    }
    public Long getBookId() {
        return this.bookId;
    }


/*
    private CustomerDto borrower;
    private BookDto borrowedBook;


    public void setBorrower(CustomerDto borrower){this.borrower = borrower;}
    public CustomerDto getBorrower(){
        return borrower;
    }
    public void setBorrowedBook(BookDto book){
        this.borrowedBook = book;
    }
    public BookDto getBorrowedBook(){
        return borrowedBook;
    }
*/

}
