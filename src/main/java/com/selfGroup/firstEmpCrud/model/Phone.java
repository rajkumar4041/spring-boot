package com.selfGroup.firstEmpCrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pNumber")
    private  String phoneNumber;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Employee employee;
}
