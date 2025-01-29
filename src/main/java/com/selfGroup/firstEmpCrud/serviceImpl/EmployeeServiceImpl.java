package com.selfGroup.firstEmpCrud.serviceImpl;

import com.selfGroup.firstEmpCrud.dto.EmployeeDto;
import com.selfGroup.firstEmpCrud.model.Employee;
import com.selfGroup.firstEmpCrud.model.Phone;
import com.selfGroup.firstEmpCrud.repository.EmployeeRepository;
import com.selfGroup.firstEmpCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addNewEmployee(Employee employee) {
        Employee empl = employeeRepository.save(employee);

        return empl;
    }

    @Override
    public Employee addNewEmployeeUsingPost(Employee employee) {
        employeeRepository.save(employee);
        return null;
    }

    @Override
    public Employee editEmployee(Employee employee) {

        Optional<Employee> empById = employeeRepository.findById(employee.getEid());

        empById.ifPresent((employee1) -> {
//          employee1.setPass(employee.getPass());
            employeeRepository.save(employee);
        });

        return null;
    }

    @Override
    public Employee deleteEmployeeById(Integer id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        employeeRepository.deleteById(id);
        return byId.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        System.out.println(allEmployees);

        return allEmployees;
    }


//    handle error with null check
//    public Employee getSingleEmployee(Integer id) {
//        Employee employeeToReturn;
//        Optional<Employee> singleEmployee = employeeRepository.findById(id);
//
//        return singleEmployee.orElse(null);
//    }

    //    through error for handling if data not present for the given id
    public Employee getSingleEmployee(Integer id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
    }

    //    public List<Employee> getAllUserByStatus() {
//        return List.of();
//    }
//
    @Override
    public List<Employee> getAllUserByStatus(Boolean active) {

        List<Employee> allActiveEmps = employeeRepository.findByActive(active);

        return allActiveEmps;
    }

    @Override
    public EmployeeDto getMyUserNameAndPass(int id) {
        EmployeeDto empDto = new EmployeeDto();
        Optional<Employee> byId = employeeRepository.findById(id);

        byId.ifPresentOrElse(emp -> {
            empDto.setUserName(emp.getUser_name());
            empDto.setPass(emp.getPass());
        }, () -> {
            empDto.setErrorMsg("Employee with ID" + id + " not found");
        });


        return empDto;
    }

    @Override
    public Employee updatePhoneNumberFromEmployee(int id, String phone) {
        return employeeRepository.findById(id).map(e -> {
                    e.getPhone().setPhoneNumber(phone);
                    return employeeRepository.save(e);
                }
        ).orElse(null);
    }
}
