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
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final BookService bookService;


    public BorrowingService(BorrowingRepository borrowingRepository, CustomerService customerService, BookService bookService, BookRepository bookRepository, CustomerRepository customerRepository) {
        this.borrowingRepository = borrowingRepository;
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;

        this.customerService = customerService;
        this.bookService = bookService;
    }

//    public void afterPropertiesSet(){
//        this.borrowingRepository = new BorrowingService();
//    }

    private static BorrowingDto mapToBorrowingDto(BorrowingEntity borrowingEntity) {
        BorrowingDto borrowingDto = new BorrowingDto();

        borrowingDto.setBorrowingId(borrowingEntity.getBorrowingId());
        borrowingDto.setCustomerId(borrowingEntity.getBorrower().getId());
        borrowingDto.setBookId(borrowingEntity.getBorrowedBook().getId());

        return borrowingDto;
    }

    @Transactional
    public BorrowingDto getBorrowing(Long borrowingId) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById(borrowingId);
        if (byId.isPresent()) {
            return mapToBorrowingDto(byId.get());
        }
        return null;
    }

    @Transactional
    public List<BorrowingDto> getBorrowings(Long borrowerId) {
        List<BorrowingDto> ret = new LinkedList<>();
        for (BorrowingEntity c1 : borrowingRepository.findAll()) {
            BorrowingDto c2 = mapToBorrowingDto(c1);
            ret.add(c2);
        }
        return ret;
    }

    @Transactional
    public Long createBorrowing(BorrowingDto borrowingDto) {
        BorrowingEntity borrowingEntity = new BorrowingEntity();

        Optional <CustomerEntity> c = customerRepository.findById(borrowingDto.getCustomerId());
        Optional <BookEntity> b = bookRepository.findById(borrowingDto.getBookId());

        if(c.isPresent()) {
            borrowingEntity.setBorrower(c.get());
        }
        if(b.isPresent()) {
            borrowingEntity.setBorrowedBook(b.get());
        }

        this.borrowingRepository.save(borrowingEntity);

        return borrowingEntity.getBorrowingId();
    }

    @Transactional
    public void updateBorrowing(Long borrowingId, BorrowingDto borrowingDto) {
        Optional<BorrowingEntity> borrowingEntity = borrowingRepository.findById(borrowingId);

        if (borrowingEntity.isPresent()) {

            Optional<CustomerEntity> c = customerRepository.findById(borrowingDto.getCustomerId());
            Optional<BookEntity> b = bookRepository.findById(borrowingDto.getBookId());

            if(c.isPresent()) {
                borrowingEntity.get().setBorrower(c.get());
            }
            if(b.isPresent()) {
                borrowingEntity.get().setBorrowedBook(b.get());
            }
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