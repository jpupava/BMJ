package com.example.demo;

public class BorrowingDto {

    private long borrowingId;
    private CustomerDto borrower;
    private BookDto borrowedBook;

    public void setBorrowingId(int borrowingId) {
        this.borrowingId = borrowingId;
    }
    public long getBorrowingId() {
        return borrowingId;
    }
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


}
