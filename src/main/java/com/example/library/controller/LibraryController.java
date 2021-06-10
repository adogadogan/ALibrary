package com.example.library.controller;


import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.User;
import com.example.library.service.BookService;
import com.example.library.service.BorrowService;
import com.example.library.service.UserService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path="/library")
public class LibraryController {

    BookService bookService;
    UserService userService;
    BorrowService borrowService;

    public LibraryController(BookService bookService, UserService userService, BorrowService borrowService) {
        this.bookService = bookService;
        this.userService = userService;
        this.borrowService = borrowService;
    }

    @GetMapping(path="/borrowedBooks")
    public List<Borrow> listBorrowedBooks(){
       return borrowService.findAll();
    }

    @GetMapping(path="/books/all")
    public List<Book> listAllBooks(){
        return bookService.findAll();
    }

    @GetMapping(path="/users/all")
    public List<User> listAllUsers(){
        return userService.findAll();
    }

    @GetMapping(path="/books/available")
    public List<Book> listAvailableBooks(){
        // expensive in terms of complexity, could be solved by a column in book entity
        // TODO
        // bookService.all - borrowService.all.book
        return bookService.findAll();
    }

    @PostMapping(path = "/borrow")
    public String borrowBook(@RequestParam("id") Long userId,
                             @RequestParam("isbn") int isbn){

        Book book = bookService.findByIsbn(isbn);
        User user = userService.findById(userId);
        borrowService.borrow(user,book);

        return "borrowed";
    }


}

