package com.selfGroup.firstEmpCrud.service;

import com.selfGroup.firstEmpCrud.dto.EmployeeDto;
import com.selfGroup.firstEmpCrud.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    public Employee addNewEmployee(Employee employee);

    //    add employee with post method
    public Employee addNewEmployeeUsingPost(Employee employee);

    public Employee editEmployee(Employee employee);

    public Employee deleteEmployeeById(Integer id);

    public List<Employee> getAllEmployees();

    public List<Employee> getAllUserByStatus(Boolean active);

    public EmployeeDto getMyUserNameAndPass(int id);

    public Employee updatePhoneNumberFromEmployee(int id, String phone);

    public Employee getSingleEmployee(Integer id);


    public List<Employee> getEmployeeByName(String name);

    public List<Employee> getEmployeeByUserName(String uName);

}
