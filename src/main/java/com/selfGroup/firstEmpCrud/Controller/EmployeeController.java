package com.selfGroup.firstEmpCrud.Controller;

import com.selfGroup.firstEmpCrud.model.Employee;
import com.selfGroup.firstEmpCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    Employee e=new Employee();

    @Autowired
    EmployeeService employeeService;

    public Employee insetEmployee(){
        e.setName("sanjeev");
        e.setAddress("himachal");
        e.setUser_name("doraemon");
        e.setPass("Sky@123");

        return employeeService.addNewEmployee(e);
    }

}
