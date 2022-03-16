package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService /*implements InitializingBean*/ {
    private final BorrowingRepository borrowingRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookService bookService;


    public BorrowingService(BorrowingRepository borrowingRepository, CustomerService customers, BookService books) {
        this.borrowingRepository = borrowingRepository;
        this.customerService = customers;
        this.bookService = books;
    }

//    public void afterPropertiesSet(){
//        this.borrowingRepository = new BorrowingService();
//    }

    private static BorrowingDto mapToBookDto(BorrowingEntity borrowingEntity) {
        BorrowingDto borrowingDto = new BorrowingDto();

        //borrowingDto.setBorrowingId(borrowingEntity.getBorrowingId());
        borrowingDto.setBorrower(borrowingEntity.getBorrower());
        borrowingDto.setBorrowedBook(borrowingEntity.getBorrowedBook());

        return borrowingDto;
    }

    @Transactional
    public BorrowingDto getBorrowing(long borrowingId) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById(borrowingId);
        if (byId.isPresent()) {
            return mapToBookDto(byId.get());
        }
        return null;
    }

    @Transactional
    public List<BorrowingDto> getBorrowings(CustomerDto borrower) {
        List<BorrowingDto> ret = new LinkedList<>();
        for (BorrowingEntity c1 : borrowingRepository.findAll()) {
            BorrowingDto c2 = mapToBookDto(c1);
            ret.add(c2);
        }
        return ret;
    }

    @Transactional
    public Long createBorrowing(BorrowingDto borrowingDto) {
        BorrowingEntity borrowingEntity = new BorrowingEntity();

        //borrowingEntity.setBorrowingId(borrowingDto.getBorrowingId());
        borrowingEntity.setBorrower(borrowingDto.getBorrower());
        borrowingEntity.setBorrowedBook(borrowingDto.getBorrowedBook());

        this.borrowingRepository.save(borrowingEntity);

        return borrowingEntity.getBorrowingId();
    }

    @Transactional
    public void updateBorrowing(long borrowingId, BorrowingDto borrowingDto) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById(borrowingId);
        if (byId.isPresent()) {
            //byId.get().setBorrowingId(borrowingDto.getBorrowingId());
            byId.get().setBorrower(borrowingDto.getBorrower());
            byId.get().setBorrowedBook(borrowingDto.getBorrowedBook());
        }
    }

    @Transactional
    public void deleteBorrowing(long borrowingId) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById(borrowingId);
        if (byId.isPresent()) {
            borrowingRepository.delete(byId.get());
        }
    }
}