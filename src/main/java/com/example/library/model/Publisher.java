package com.example.library.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public Publisher() {
    }
    public Publisher(String name) {
        this.name = name;
    }

}
