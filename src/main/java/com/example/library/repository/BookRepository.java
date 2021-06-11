package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
    Book findFirstByIsbn(int isbn) ;

    List<Book> findByCountGreaterThan(int count);

}
