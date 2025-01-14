package com.selfGroup.firstEmpCrud.serviceImpl;

import com.selfGroup.firstEmpCrud.model.Employee;
import com.selfGroup.firstEmpCrud.repository.EmployeeRepository;
import com.selfGroup.firstEmpCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addNewEmployee(Employee employee) {
        Employee empl=employeeRepository.save(employee);

        return empl;
    }

    @Override
    public Employee editEmployee(Employee employee) {

        Optional<Employee> empById = employeeRepository.findById(employee.getEid());

            empById.ifPresent((employee1)->{
//          employee1.setPass(employee.getPass());
            employeeRepository.save(employee);
        });

        return null;
    }
    @Override
    public Employee deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
        
        return null; }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        System.out.println(allEmployees);

        return allEmployees;
    }
}
