package com.selfGroup.firstEmpCrud.repository;

import com.selfGroup.firstEmpCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByActive(Boolean active);

//    custom finder method

    List<Employee> findByName(String name);

    List<Employee> findByUserName(String userName);

}
