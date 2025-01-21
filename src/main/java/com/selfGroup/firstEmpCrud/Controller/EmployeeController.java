package com.selfGroup.firstEmpCrud.Controller;

import com.selfGroup.firstEmpCrud.dto.EmployeeDto;
import com.selfGroup.firstEmpCrud.model.Employee;
import com.selfGroup.firstEmpCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    Employee e = new Employee();

    @Autowired
    private EmployeeService employeeService;

    public Employee insetEmployee() {
        e.setName("amit");
        e.setAddress("pune");
        e.setUser_name("amit_09");
        e.setPass("Amit@123");

        return employeeService.addNewEmployee(e);
    }

    //Inset hardcode method without postMapping request
    @PostMapping(value = "/registerEmp")
    public String addEmployeeWithPost(@RequestBody Employee e1) {
        employeeService.addNewEmployeeUsingPost(e1);
        return "Successfully Added New Employee";
    }

    //Inset hardcode method without putMapping request
    //    public Employee editEmployee() {
    //        e.setName("rohan");
    //        e.setAddress("pune");
    //        e.setUser_name("rohan_05");
    //        e.setPass("Rohan@123");
    //        e.setEid(2);
    //
    //        return employeeService.editEmployee(e);
    //    }

    //By  putMapping request
    @PutMapping("/updateEmp")
    public Employee editEmployee(@RequestBody Employee employee) {
        return employeeService.editEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.deleteEmployeeById(id);
        return "Successfully Removed " + employee.getName();
//                + employee.getName();
    }

    @GetMapping("/get")
    public List<Employee> getAllUser() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getSingle")
    public Employee getSingleEmployee(@RequestParam Integer id) {
        return employeeService.getSingleEmployee(id);
    }

    @GetMapping("/status/{active}")
    public List<Employee> getAllUserByStatus(@PathVariable Boolean active) {
        return employeeService.getAllUserByStatus(active);
    }


    @GetMapping("/getCred/{id}")
    public EmployeeDto getMyUserNamePass(@PathVariable int id) {

        EmployeeDto empDto = employeeService.getMyUserNameAndPass(id);
        return empDto;
    }

}
