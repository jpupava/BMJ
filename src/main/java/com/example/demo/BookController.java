package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private List<Book> books;
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private List<Book> initBook() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(0L);
        book1.setauthorFirstname("Peter");
        book1.setauthorLastname("Lynch");
        book1.settitle("One up on Wall Street");
        book1.setisbn("ISBN12A69C");
        book1.setcount(10);
        books.add(book1);

        Book book2 = new Book();
        book2.setId(0L);
        book2.setauthorFirstname("Matko");
        book2.setauthorLastname("Usko");
        book2.settitle("matko-usko");
        book2.setisbn("ISBN15A29C");
        book2.setcount(8);
        books.add(book2);

        return books;
    }

    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId){
        return bookService.getBook(bookId);
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String autorName){
        return bookService.getBooks(autorName);
    }
    @PostMapping("/api/books")
    public Integer addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable int bookId, @RequestBody Book book){
        bookService.updateBook(bookId, book);
    }
}
