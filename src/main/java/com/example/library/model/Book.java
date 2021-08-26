package com.example.library.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int isbn;

    private String title;
    private int count;
    private String genre;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name="book_author",  joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns =@JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<>() ;

    public Book(int isbn, String title, int count) {
        this.isbn = isbn;
        this.title = title;
        this.count = count;
    }
    public Book() {
    }
}
