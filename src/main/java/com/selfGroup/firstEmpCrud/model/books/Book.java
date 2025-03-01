package com.selfGroup.firstEmpCrud.model.books;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    /*
     * @JsonManagedReference
     * tells that i am parent entity managing the child
     * use with JsonBackReference
     * manage reference convert into json but JsonBackReference not converted
     */
    @JsonManagedReference
    public Author author;
}
