package com.example.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor // why the need ?
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","book_id"})})
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= CascadeType.MERGE,optional = false) // when the user borrows for the first time, merge is needed
    private User user;

    @ManyToOne(optional = false) // if there is no book in repo, then borrow is not possible? else: cascade.Full
    private Book book;

    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    public Borrow(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
