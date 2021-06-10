package com.example.library.service;

import com.example.library.model.Book;

public interface BookService extends CrudService<Book,Long> {

    Book findByIsbn(int isbn);

}
