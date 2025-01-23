package com.selfGroup.firstEmpCrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emp")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "address")
    private String Address;

    private Boolean active;

    @Column(name = "u_name")
    private String user_name;

    private String pass;

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;

//TODO: SINCE we are added dependency of Lombok we don't need to add getter/setter
//TODO: all getter/setter stuff done by @Data Annotation

//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//
//
//    public int getEid() {
//        return eid;
//    }
//
//    public void setEid(int eid) {
//        this.eid = eid;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return Address;
//    }
//
//    public void setAddress(String address) {
//        Address = address;
//    }
//
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass = pass;
//    }

//    public Employee() {
//    }

//    public Employee(Employee e) {
//        this.eid = e.getEid();
//        this.pass = e.getPass();
//        this.user_name = e.getUser_name();
//        Address = e.getAddress();
//        this.name = e.getName();
//    }

}
