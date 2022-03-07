package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService {

    private List<Borrowing> borrowings;
    private CustomerService customerService;
    private BookService bookService;


    public BorrowingService() {
        this.borrowings = initBorrowing();
    }

    private List<Borrowing> initBorrowing() {
        List<Borrowing> borrowings = new ArrayList<>();

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setBorrowingId(0);
        borrowing1.setBorrower(customerService.getCustomer(0));
        borrowing1.setBorrowedBook(bookService.getBook(0));
        /*
        borrowing1.setCustomerId(5);
        borrowing1.setCustomerName("Janko Mrkvicka");
        borrowing1.setBookId(3);
        borrowing1.setTitle("Hobbit");
        borrowing1.setAuthorName("J. R. R. Tolkien");
        */
        borrowings.add(borrowing1);

        Borrowing borrowing2 = new Borrowing();
        borrowing2.setBorrowingId(1);
        borrowing2.setBorrower(customerService.getCustomer(1));
        borrowing2.setBorrowedBook(bookService.getBook(1));
        /*
        borrowing2.setCustomerId(14);
        borrowing2.setCustomerName("Karol Bezdeda");
        borrowing2.setBookId(12);
        borrowing2.setTitle("O ciernej diere");
        borrowing2.setAuthorName("Steven Hawking");
         */
        borrowings.add(borrowing2);

        return borrowings;
    }


    public Borrowing getBorrowing(int borrowingId){
        return this.borrowings.get(borrowingId);
    }


    public List<Borrowing> getBorrowings(Customer borrower){

        List<Borrowing> filteredBorrowings = new ArrayList<>();
        for (Borrowing borrowing : borrowings){
            if (borrowing.getBorrower().equals(borrower)){
                filteredBorrowings.add(borrowing);
            }
        }

        if(borrower==null){
            return this.borrowings;
        }
        return filteredBorrowings;

    }


    public Integer createBorrowing(Borrowing borrowing){

        this.borrowings.add(borrowing);
        this.borrowings.get(borrowings.size()-1).setBorrowingId(borrowings.size()-1);
        return this.borrowings.size()-1;
    }


    public void deleteBorrowing(int borrowingId){
        this.borrowings.remove(this.borrowings.get(borrowingId));
    }


    public void updateBorrowing(int borrowingId, Borrowing borrowing) {
        this.borrowings.get(borrowingId).setBorrowingId(borrowingId);
        this.borrowings.get(borrowingId).setBorrower(borrowing.getBorrower());
        this.borrowings.get(borrowingId).setBorrowedBook(borrowing.getBorrowedBook());

        /*
        this.borrowings.get(borrowingId).setCustomerId(borrowing.getCustomerId());
        this.borrowings.get(borrowingId).setCustomerName(borrowing.getCustomerName());
        this.borrowings.get(borrowingId).setBookId(borrowing.getBookId());
        this.borrowings.get(borrowingId).setAuthorName(borrowing.getAuthorName());
        this.borrowings.get(borrowingId).setTitle(borrowing.getTitle());
         */
    }

}
