package com.example.library.controller;


import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.User;
import com.example.library.service.BookService;
import com.example.library.service.BorrowService;
import com.example.library.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;
import java.util.List;

@Api(value = "Library main API ") //could not find it
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

    @GetMapping(path="/borrows")
    @ApiOperation(value = "Shows borrowed books",
    notes = "Provides a list of borrowed books from the library")
    public List<Borrow> listBorrowedBooks(){
       return borrowService.findAll();
    }

    @GetMapping(path="/books")
    public List<Book> listAllBooks(){
        return bookService.findAll();
    }

    @GetMapping(path="/users")
    public List<User> listAllUsers(){
        return userService.findAll();
    }

    @GetMapping(path="/books-available")
    public List<Book> listAvailableBooks(){
        return bookService.listAvailableBooks();
    }

    @PostMapping(path = "/borrow-book")
    public String borrowBook(@RequestParam("id") Long userId,
                             @RequestParam("isbn") int isbn) throws SQLException {

        Book book = bookService.findByIsbn(isbn);
        User user = userService.findById(userId);
        if (book.getCount()>0){ // book count table instead of a column ?
            borrowService.borrowBook(user,book);
            return "borrowed";
        }
        else{
            System.out.println("No available book!");
            return "no Available Book";
        }
    }

    @PostMapping(path="/return-book")
    public String returnBook(@RequestParam("id") Long userId,
                             @RequestParam("isbn") int isbn){

        Long bookId = bookService.findByIsbn(isbn).getId();// no type checkk !
        Borrow borrow = borrowService.findByUserIdAndBookId(userId,bookId);
        if (borrow != null){
            borrowService.returnBook(borrow); // this time, returnBook will handle book.count
            return "Returned" ;
        }
        else{
            return "No borrow History found" ;
        }
    }

}

