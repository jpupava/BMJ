package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {

    private List<Borrowing> borrowings;

    public BorrowingsController() {
        this.borrowings = initBorrowing();
    }

    private List<Borrowing> initBorrowing() {
        List<Borrowing> borrowings = new ArrayList<>();

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setBorrowingId(0);
        borrowing1.setCustomerId(5);
        borrowing1.setCustomerName("Janko Mrkvicka");
        borrowing1.setBookId(3);
        borrowing1.setTitle("Hobbit");
        borrowing1.setAuthorName("J. R. R. Tolkien");
        borrowings.add(borrowing1);

       /* Borrowing borrowing2 = new Borrowing();
        borrowing2.setBorrowingId(1);
        borrowing2.setCustomerId(14);
        borrowing2.setCustomerName("Karol Bezdeda");
        borrowing2.setBookId(12);
        borrowing2.setTitle("O ciernej diere");
        borrowing2.setAuthorName("Steven Hawking");
        borrowings.add(borrowing2);*/

        return borrowings;
    }

    @GetMapping("/api/borrowings/{borrowingId}")
    public Borrowing getBorrowing(@PathVariable Integer borrowingId){
        System.out.println(borrowingId);
        return this.borrowings.get(borrowingId);
    }

    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowings(@RequestParam(required = false) String customerName){

        List<Borrowing> filteredBorrowings = new ArrayList<>();
        for (Borrowing borrowing : borrowings){
            if (borrowing.getCustomerName().equals(customerName)){
                filteredBorrowings.add(borrowing);
            }
        }

        if(customerName==null){
            return this.borrowings;
        }
        return filteredBorrowings;

    }

    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody Borrowing borrowing){

        this.borrowings.add(borrowing);
        this.borrowings.get(borrowings.size()-1).setBorrowingId(borrowings.size()-1);
        return this.borrowings.size()-1;
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){

        this.borrowings.remove(this.borrowings.get(borrowingId));
    }

    @PutMapping("/api/borrowings/{borrowingId}")
    public void updateBorrowing(@PathVariable int borrowingId, @RequestBody Borrowing borrowing) {
        this.borrowings.get(borrowingId).setBorrowingId(borrowingId);
        this.borrowings.get(borrowingId).setCustomerId(borrowing.getCustomerId());
        this.borrowings.get(borrowingId).setCustomerName(borrowing.getCustomerName());
        this.borrowings.get(borrowingId).setBookId(borrowing.getBookId());
        this.borrowings.get(borrowingId).setAuthorName(borrowing.getAuthorName());
        this.borrowings.get(borrowingId).setTitle(borrowing.getTitle());
    }

}
