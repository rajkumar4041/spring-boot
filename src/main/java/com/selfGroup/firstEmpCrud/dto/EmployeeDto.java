package com.selfGroup.firstEmpCrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class EmployeeDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int eid;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pass;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMsg;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "eid=" + eid +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
