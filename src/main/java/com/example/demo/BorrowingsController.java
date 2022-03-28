package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {

    private List<BorrowingDto> borrowingDtos;

    private BorrowingService borrowingService;
    private CustomerService customerService ;
    private BookService bookService;

    public BorrowingsController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    private List<BorrowingDto> initBorrowing() {
        List<BorrowingDto> borrowingDtos = new ArrayList<>();

        BorrowingDto borrowingDto1 = new BorrowingDto();
        borrowingDto1.setBorrowingId(0L);

        borrowingDto1.setBorrowingId(0L);
        borrowingDto1.setCustomerId(0L);
        borrowingDto1.setBookId(0L);
        /*borrowingDto1.setBorrower(customerService.getCustomer(0L));
        borrowingDto1.setBorrowedBook(bookService.getBook(0L));
        */
        borrowingDtos.add(borrowingDto1);


        BorrowingDto borrowingDto2 = new BorrowingDto();
        borrowingDto2.setBorrowingId(1L);

        borrowingDto2.setCustomerId(1L);
        borrowingDto2.setBookId(1L);
        /*
        borrowingDto2.setBorrower(customerService.getCustomer(1L));
        borrowingDto2.setBorrowedBook(bookService.getBook(1L));
        */
        borrowingDtos.add(borrowingDto2);

        return borrowingDtos;
    }

    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowingDto getBorrowing(@PathVariable long borrowingId){
        return borrowingService.getBorrowing(borrowingId);
    }

    @GetMapping("/api/borrowings")
    public List<BorrowingDto> getBorrowings(@RequestParam(required = false) Long borrowerId){
        return borrowingService.getBorrowings(borrowerId);

    }

    @PostMapping("/api/borrowings")
    public long createBorrowing(@RequestBody BorrowingDto borrowingDto){
        return borrowingService.createBorrowing(borrowingDto);
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        borrowingService.deleteBorrowing(borrowingId);
    }

    @PutMapping("/api/borrowings/{borrowingId}")
    public void updateBorrowing(@PathVariable Long borrowingId, @RequestBody BorrowingDto borrowingDto) {
        borrowingService.updateBorrowing(borrowingId, borrowingDto);
    }

}