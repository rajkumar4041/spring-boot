package com.selfGroup.firstEmpCrud.Controller;

import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Team;
import com.selfGroup.firstEmpCrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {

        return departmentService.addDepartment(department);
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestParam int id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }


    @GetMapping("/getAllDepartment")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public Department deleteDepartment(@PathVariable int id) {
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/getAllTeamsByDepartmentId")
    public String getAllTeams(@PathVariable int depId) {
        List<Team> myAllTeams = departmentService.getMyAllTeams(depId);

        if (!myAllTeams.isEmpty()) return "All Teams Fetch Successfully";

        return "No Any Team found";
    }


}
