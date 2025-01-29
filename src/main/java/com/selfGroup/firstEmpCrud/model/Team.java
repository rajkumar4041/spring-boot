package com.selfGroup.firstEmpCrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Added fetch = FetchType.LAZY for performance optimization
    @JsonBackReference // Added to manage serialization and avoid infinite recursion
    @ToString.Exclude // Excluded from toString to avoid circular dependency
//    @JsonIgnore//     @JsonIgnore -> Prevent serialization of this field and to Break the cyclic Reference//dep -> team   // team -> dep
    private Department department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team", fetch = FetchType.EAGER) // Added fetch = FetchType.LAZY for performance optimization
    @JsonManagedReference // Added to manage serialization and avoid infinite recursion
    @ToString.Exclude // Excluded from toString to avoid circular dependency
    private List<Employee> employeeList;
}
