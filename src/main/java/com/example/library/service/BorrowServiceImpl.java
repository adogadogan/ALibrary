package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Borrow;
import com.example.library.model.User;
import com.example.library.repository.BorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    BorrowRepository borrowRepository ;

    public BorrowServiceImpl(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
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
    public void borrow(User user, Book book) {
        Borrow borrow = new Borrow(user,book);
        this.save(borrow);
    }
}
