package com.selfGroup.firstEmpCrud.service;

import com.selfGroup.firstEmpCrud.model.Employee;

public interface EmployeeService  {


    public Employee addNewEmployee(Employee employee);

    public Employee editEmployee(Employee employee);

    public Employee deleteEmployee(Integer id);

}
