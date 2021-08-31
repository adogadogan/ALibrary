package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    BookRepository bookRepository ;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    @Cacheable(value="itemCache",key="#p0",unless = "#result.count < 3")
    public Book findById(Long aLong) {
        System.out.println("Request: "+aLong);
        return bookRepository.findById(aLong).orElse(null);
    }

    @Override
    public Book save(Book object) {
        return bookRepository.save(object);
    }

    @Override
    public void delete(Book object) {
        bookRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bookRepository.deleteById(aLong);
    }

    @Override
    public Book findByIsbn(int isbn) {
        // !! NO ERROR CHECK XD
        return bookRepository.findFirstByIsbn(isbn);
    }

    @Override
    public List<Book> listAvailableBooks() {
        return bookRepository.findByCountGreaterThan(0);
    }
}
