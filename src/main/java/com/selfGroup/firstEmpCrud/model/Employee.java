package com.selfGroup.firstEmpCrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int eid;

    @Column(name = "emp_name")
    public String name;

    @Column(name = "address")
    public String Address;

    @Column(name = "u_name")
    public String user_name;

    public String pass;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public  Employee(){}

    public Employee(Employee e) {
        this.eid = e.getEid();
        this.pass = e.getPass();
        this.user_name = e.getUser_name();
        Address = e.getAddress();
        this.name = e.getName();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                ", user_name='" + user_name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
