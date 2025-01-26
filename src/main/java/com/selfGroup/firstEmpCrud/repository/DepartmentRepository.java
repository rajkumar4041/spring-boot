package com.selfGroup.firstEmpCrud.repository;

import com.selfGroup.firstEmpCrud.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
