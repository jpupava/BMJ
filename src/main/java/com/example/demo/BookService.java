package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private static BookDto mapToBookDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();

        bookDto.setAuthorFirstname(bookEntity.getAuthorFirstname());
        bookDto.setTitle(bookEntity.getTitle());

        return bookDto;
    }

    @Transactional
    public List<BookDto> getBooks(String bookAuthor) {
        List<BookDto> ret = new LinkedList<>();
        for (BookEntity b1 : bookRepository.findAll()) {
            BookDto b2 = mapToBookDto(b1);
            ret.add(b2);
        }
        return ret;
    }

    @Transactional
    public BookDto getBook(Long bookId) {
        Optional<BookEntity> byId = bookRepository.findById(bookId);
        return byId.map(BookService::mapToBookDto).orElse(null);
    }

    @Transactional
    public Long createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthorFirstname(bookDto.getAuthorFirstname());
        bookEntity.setTitle(bookDto.getTitle());

        this.bookRepository.save(bookEntity);

        return bookEntity.getId();
    }

    @Transactional
    public void updateBook(int bookId, BookDto bookDto) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            byId.get().setAuthorFirstname(bookDto.getAuthorFirstname());
            byId.get().setTitle(bookDto.getTitle());
        }
    }

    @Transactional
    public void deleteBook(int bookId) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        byId.ifPresent(bookRepository::delete);
    }

}