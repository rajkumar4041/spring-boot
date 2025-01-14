package com.selfGroup.firstEmpCrud.service;

import com.selfGroup.firstEmpCrud.model.Employee;

import java.util.List;

public interface EmployeeService  {


    public Employee addNewEmployee(Employee employee);

    public Employee editEmployee(Employee employee);

    public Employee deleteEmployeeById(Integer id);

    public List<Employee> getAllEmployees();

    public Employee getSingleEmployee(Integer id);

}
