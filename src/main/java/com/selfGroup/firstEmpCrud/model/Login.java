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
    private String userName;

    private String pass;

    private  Boolean isUserLoggedIn;

    private  Boolean active;

    private Date lastLogin;

//    private Employee employee;

    public Login(String userName, String pass, Boolean isUserLoggedIn, Boolean active, Date lastLogin) {
        this.userName = userName;
        this.pass = pass;
        this.isUserLoggedIn = isUserLoggedIn;
        this.active = active;
        this.lastLogin = lastLogin;
    }
}
