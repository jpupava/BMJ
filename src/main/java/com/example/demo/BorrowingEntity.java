package com.example.demo;
import javax.persistence.*;

@Entity
public class BorrowingEntity {

    @Id
    @GeneratedValue
    private Long borrowingId;
/*
    @JoinColumn(name = "customerId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity borrower;

    @JoinColumn(name = "bookId")
    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity borrowedBook;
*/
    private Long customerId;
    private Long bookId;

    public void setBorrowingId(long borrowingId) {
        this.borrowingId = borrowingId;
    }
    public Long getBorrowingId() {
        return borrowingId;
    }

    /*
    public void setBorrower(CustomerDto borrower){this.borrower = borrower;}
    public CustomerEntity getBorrower(){
        return borrower;
    }
    public void setBorrowedBook(BookDto book){
        this.borrowedBook = book;
    }
    public BookEntity getBorrowedBook(){
        return borrowedBook;
    }
    */
    public Long getCustomerId(){
        return this.customerId;
    }
    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }
    public void setBookId(Long bookId){
        this.bookId = bookId;
    }
    public Long getBookId() {
        return this.bookId;
    }

}
