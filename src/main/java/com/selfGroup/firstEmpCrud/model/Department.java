package com.selfGroup.firstEmpCrud.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
//    @JsonInclude(JsonInclude.Include.NON_NULL
    @JsonManagedReference // Added to manage serialization and avoid infinite recursion
    @ToString.Exclude // Excluded from toString to avoid circular dependency
    private List<Team> teams;


}
