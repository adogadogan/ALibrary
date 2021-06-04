package com.example.library.service;

import com.example.library.model.Borrow;
import com.example.library.repository.BorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BorrowService implements IBorrowService{
    BorrowRepository borrowRepository ;

    public BorrowService(BorrowRepository borrowRepository) {
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
}
