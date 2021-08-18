package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path="/add")
    public String addNewBook(@RequestBody Book book){
        bookService.save(book);
        return "saved";
    }

    @GetMapping(path="/all")
    public List<Book> listAllBooks(){
        return bookService.findAll();
    }

    @PostMapping(path = "/remove")
    public String removeBook(@RequestParam Long bookId){
        // borrow felan da temizlenmeli yoksa silmez.
        bookService.deleteById(bookId);
        return "deleted";
    }

    @PostMapping(path = "/update")
    public String updateBook(@RequestParam Long bookId,@RequestParam int newCount){
        Book book = bookService.findById(bookId);
        book.setCount(newCount);
        bookService.save(book);
        return "updated";
    }

}
