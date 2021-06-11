package com.example.library.controller;


import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.User;
import com.example.library.service.BookService;
import com.example.library.service.BorrowService;
import com.example.library.service.UserService;
import org.springframework.web.bind.annotation.*;

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
        return bookService.listAvailableBooks();
    }

    @PostMapping(path = "/borrow")
    public String borrowBook(@RequestParam("id") Long userId,
                             @RequestParam("isbn") int isbn){

        Book book = bookService.findByIsbn(isbn);
        User user = userService.findById(userId);
        if (book.getCount()>0){ // book count table instead of a column ?
            book.setCount(book.getCount()-1);//Should be handled here, or in borrowService?
            borrowService.borrowBook(user,book);
            bookService.save(book);
            return "borrowed";
        }
        else{
            System.out.println("No available book!");
            return "no Available Book";
        }
    }

    @PostMapping(path="/return")
    public String returnBook(@RequestParam("id") Long userId,
                             @RequestParam("isbn") int isbn){

        Long bookId = bookService.findByIsbn(isbn).getId();// no type checkk !
        Borrow borrow = borrowService.findByUserIdAndBookId(userId,bookId);
        if (borrow != null ){
            borrowService.returnBook(borrow); // this time, returnBook will handle book.count
            return "Returned" ;
        }
        else{
            return "No borrow History found" ;
        }
    }

}

