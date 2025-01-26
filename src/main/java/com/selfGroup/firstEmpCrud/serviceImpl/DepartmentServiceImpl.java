package com.selfGroup.firstEmpCrud.serviceImpl;


import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Team;
import com.selfGroup.firstEmpCrud.repository.DepartmentRepository;
import com.selfGroup.firstEmpCrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int id, Department department) {

        Optional<Department> byId = departmentRepository.findById(id);
        return byId.orElse(null);
    }


    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department deleteDepartment(int id) {
        Optional<Department> byId = departmentRepository.findById(id);
        departmentRepository.deleteById(id);
        return byId.orElse(null);
    }


    public List<Team> getMyAllTeams(int departmentId) {
        Optional<Department> byId = departmentRepository.findById(departmentId);
        return byId.map(Department::getTeams).orElse(null);
    }

}
