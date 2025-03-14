package com.selfGroup.firstEmpCrud.service;


import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Team;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {

    public Department addDepartment(Department department);

    public Department updateDepartment(int id, Department department);

    public ResponseEntity<List<Department>> getAllDepartment();

    public Department deleteDepartment(int id);

    public List<Team> getMyAllTeams(int departmentId);

    public Department addTeamWithEmployee(int departmentId, int empId);


}
