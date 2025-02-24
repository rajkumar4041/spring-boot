package com.selfGroup.firstEmpCrud.model.books;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String title;

    @OneToOne(cascade = CascadeType.ALL)
    public Author author;
}
