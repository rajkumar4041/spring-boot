package com.selfGroup.firstEmpCrud.model;

public class Employee {

    public int eid;

    public String name;

    public String Address;

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
