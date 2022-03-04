package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {

    private List<Borrowing> borrowings;

    private BorrowingService borrowingService;

    public BorrowingsController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
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

        Borrowing borrowing2 = new Borrowing();
        borrowing2.setBorrowingId(1);
        borrowing2.setCustomerId(14);
        borrowing2.setCustomerName("Karol Bezdeda");
        borrowing2.setBookId(12);
        borrowing2.setTitle("O ciernej diere");
        borrowing2.setAuthorName("Steven Hawking");
        borrowings.add(borrowing2);

        return borrowings;
    }

    @GetMapping("/api/borrowings/{borrowingId}")
    public Borrowing getBorrowing(@PathVariable Integer borrowingId){
        return borrowingService.getBorrowing(borrowingId);
    }

    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowings(@RequestParam(required = false) String customerName){
        return borrowingService.getBorrowings(customerName);

    }

    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody Borrowing borrowing){
        return borrowingService.createBorrowing(borrowing);
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        borrowingService.deleteBorrowing(borrowingId);
    }

    @PutMapping("/api/borrowings/{borrowingId}")
    public void updateBorrowing(@PathVariable int borrowingId, @RequestBody Borrowing borrowing) {
        borrowingService.updateBorrowing(borrowingId, borrowing);
    }

}
