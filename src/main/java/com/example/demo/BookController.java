package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    private List<Book> books;

    public BookController() {
        this.books = initBook();
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
        return this.books.get(bookId);
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookTitle){

        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books){
            if (book.gettitle().equals(bookTitle)){
                filteredBooks.add(book);
            }
        }
        System.out.println(bookTitle);
        if(bookTitle==null){
            return this.books;
        }
        return filteredBooks;

    }

    @PostMapping("/api/books")
    public Integer addBook(@RequestBody Book book){
        this.books.add(book);
        this.books.get(books.size()-1).setId(Long.valueOf(books.size()-1));
        return this.books.size()-1;
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    @PutMapping("/api/customers/{customerId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setId(Long.valueOf(bookId));
        this.books.get(bookId).setauthorFirstname(book.getauthorFirstname());
        this.books.get(bookId).setauthorLastname(book.getauthorLastname());
        this.books.get(bookId).settitle(book.gettitle());
        this.books.get(bookId).setisbn(book.getisbn());
        this.books.get(bookId).setcount(book.getcount());
    }
}
