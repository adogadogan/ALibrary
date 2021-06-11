package com.example.library.service;

import com.example.library.model.Book;

import java.util.List;

public interface BookService extends CrudService<Book,Long> {

    Book findByIsbn(int isbn);
    List<Book> listAvailableBooks();
}
