package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.User;

public interface BorrowService extends CrudService<Borrow,Long> {

    void borrow(User user, Book book);
}
