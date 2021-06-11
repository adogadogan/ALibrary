package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRepository;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    BorrowRepository borrowRepository;
    BookRepository bookRepository;
    UserRepository userRepository;
    // BookRepo or BookService ?
    public BorrowServiceImpl(BorrowRepository borrowRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Borrow> findAll() {
        return (List<Borrow>) borrowRepository.findAll();
    }

    @Override
    public Borrow findById(Long aLong) {
        return borrowRepository.findById(aLong).orElse(null);
    }

    @Override
    public Borrow save(Borrow object) {
        return borrowRepository.save(object);
    }

    @Override
    public void delete(Borrow object) {
        borrowRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        borrowRepository.deleteById(aLong);
    }

    @Override
    public void borrowBook(User user, Book book) {
        Borrow borrow = new Borrow(user,book);
        borrow.setBorrowDate(LocalDateTime.now());
        borrow.setDueDate(LocalDateTime.now().plusDays(7L)); // this is variable in real life, with enum prob.
        this.save(borrow);
    }

    @Override
    public Borrow findByUserIdAndBookId(Long userId, Long bookId) {
        return borrowRepository.findByUserIdAndBookId(userId,bookId);
    }

    @Override
    public void returnBook(Borrow borrow) {

        Book returnedBook = borrow.getBook();
        returnedBook.setCount(returnedBook.getCount()+1);
        bookRepository.save(returnedBook);

        borrow.setReturnDate(LocalDateTime.now());
        this.save(borrow);
    }

}

