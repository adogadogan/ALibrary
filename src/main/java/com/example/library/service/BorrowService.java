package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.User;

public interface BorrowService extends CrudService<Borrow,Long> {

    void borrowBook(User user, Book book);
    Borrow findByUserIdAndBookId(Long userId, Long bookId);
    void returnBook(Borrow borrow);

}
