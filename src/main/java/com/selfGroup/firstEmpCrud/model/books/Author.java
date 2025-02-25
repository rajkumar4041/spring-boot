package com.selfGroup.firstEmpCrud.model.books;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    //  bi-directional mapping
    // this will create one more column in the database so we need to avoid this we use MAPPED_BY and field which will replace this
    // mappedBy  column name which book field already mapped with author class i.e author field of book already mapped with Author entity
    @OneToOne(mappedBy = "author")

    /* ` @JsonBackReference `
     *  manage by parent entity Books field - Author
     * it tell spring boot that we already come from the mapped entity so we dont need to go ``backWard direction``
     * prevent recursive call & infinite loop call by toString()
     */
    @JsonBackReference
    private Book book;
}
