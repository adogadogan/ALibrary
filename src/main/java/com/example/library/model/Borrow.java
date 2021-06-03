package com.example.library.model;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade= CascadeType.MERGE) // when the user borrows for the first time, merge is needed
    private User user;

    @OneToOne // if there is no book in repo, then borrow is not possible? else: cascade.Full
    private Book book;

    public Borrow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    // borrowDate
    // returnDate
    // dueDate

}
