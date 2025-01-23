package com.selfGroup.firstEmpCrud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "uName")
    private String UserName;

    private String pass;

    private  Boolean isUserLoggedIn;

    private  Boolean active;

    private Date lastLogin;

//    private Employee employee;

    public Login(String pass, String userName) {
        this.pass = pass;
        UserName = userName;
    }
}
