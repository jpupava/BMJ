package com.example.demo;
import javax.persistence.*;

@Entity
public class BorrowingEntity {

    @Id
    @GeneratedValue
    private long borrowingId;

    @JoinColumn
    @ManyToOne
    private CustomerDto borrower;

    @JoinColumn
    @ManyToOne
    private BookDto borrowedBook;

    public void setBorrowingId(long borrowingId) {
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
