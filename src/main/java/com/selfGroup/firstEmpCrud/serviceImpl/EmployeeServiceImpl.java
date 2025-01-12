package com.selfGroup.firstEmpCrud.serviceImpl;

import com.selfGroup.firstEmpCrud.model.Employee;
import com.selfGroup.firstEmpCrud.repository.EmployeeRepository;
import com.selfGroup.firstEmpCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee addNewEmployee(Employee employee) {
        Employee empl=employeeRepository.save(employee);

        return empl;
    }
}
