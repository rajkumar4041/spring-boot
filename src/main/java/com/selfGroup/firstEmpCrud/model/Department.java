package com.selfGroup.firstEmpCrud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Employee> employeeList;


    @OneToMany(cascade = CascadeType.DETACH)
    private List<Team> teams;


}
