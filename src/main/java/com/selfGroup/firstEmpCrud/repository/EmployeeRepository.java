package com.selfGroup.firstEmpCrud.repository;

import com.selfGroup.firstEmpCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {}
