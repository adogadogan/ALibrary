package com.example.library.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Publisher implements Serializable {
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

    public Publisher(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
