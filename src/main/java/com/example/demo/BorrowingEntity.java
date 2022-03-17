package com.example.demo;
import javax.persistence.*;

@Entity
public class BorrowingEntity {

    @Id
    @GeneratedValue
    private long borrowingId;

    @JoinColumn
    @ManyToOne
    private CustomerEntity borrower;

    @JoinColumn
    @ManyToOne
    private BookEntity borrowedBook;

    public void setBorrowingId(long borrowingId) {
        this.borrowingId = borrowingId;
    }
    public long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrower(CustomerEntity borrower){this.borrower = borrower;}
    public CustomerEntity getBorrower(){
        return borrower;
    }
    public void setBorrowedBook(BookEntity book){
        this.borrowedBook = book;
    }
    public BookEntity getBorrowedBook(){
        return borrowedBook;
    }
}
