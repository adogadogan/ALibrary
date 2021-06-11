package com.example.library.repository;

import com.example.library.model.Borrow;
import org.springframework.data.repository.CrudRepository;


public interface BorrowRepository extends CrudRepository<Borrow,Long> {
    Borrow findByUserIdAndBookId(Long userId,Long bookId);
}
