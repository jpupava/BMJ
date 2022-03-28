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

        bookDto.setId(bookEntity.getId());
        bookDto.setAuthorFirstname(bookEntity.getAuthorFirstname());
        bookDto.setAuthorLastname(bookEntity.getAuthorLastname());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setIsbn(bookEntity.getIsbn());
        bookDto.setCount(bookEntity.getCount());

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
        if (byId.isPresent()) {
            return mapToBookDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthorFirstname(bookDto.getAuthorFirstname());
        bookEntity.setAuthorLastname(bookDto.getAuthorLastname());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setIsbn(bookDto.getIsbn());
        bookEntity.setCount(bookDto.getCount());

        this.bookRepository.save(bookEntity);

        return bookEntity.getId();
    }

    @Transactional
    public void updateBook(int bookId, BookDto bookDto) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            byId.get().setAuthorFirstname(bookDto.getAuthorFirstname());
            byId.get().setAuthorLastname(bookDto.getAuthorLastname());
            byId.get().setTitle(bookDto.getTitle());
            byId.get().setIsbn(bookDto.getIsbn());
            byId.get().setCount(bookDto.getCount());
        }
    }

    @Transactional
    public void deleteBook(int bookId) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            bookRepository.delete(byId.get());
        }
    }

}