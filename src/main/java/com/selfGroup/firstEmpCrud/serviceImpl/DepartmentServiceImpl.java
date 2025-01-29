package com.selfGroup.firstEmpCrud.serviceImpl;


import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Employee;
import com.selfGroup.firstEmpCrud.model.Team;
import com.selfGroup.firstEmpCrud.repository.DepartmentRepository;
import com.selfGroup.firstEmpCrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        // Iterate through teams and set the department reference
        if (department.getTeams() != null) {
            for (Team team : department.getTeams()) {
                team.setDepartment(department); // Set the department reference in Team

                // Iterate through employees and set the team reference
                if (team.getEmployeeList() != null) {
                    for (Employee employee : team.getEmployeeList()) {
                        employee.setTeam(team); // Set the team reference in Employee
                    }
                }
            }
        }
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int id, Department department) {
        Optional<Department> byId = departmentRepository.findById(id);

        return byId.map(exDepartment -> {
            exDepartment.setName(department.getName());
            exDepartment.setTeams(department.getTeams());
            return departmentRepository.save(exDepartment);
        }).orElse(null);
    }


    public List<Department> getAllDepartment() {
        List<Department> collect = departmentRepository.findAll().stream().map((department) -> {
            List<Team> teams = department.getTeams();
            department.setTeams(teams);
            teams.stream().map((team) -> {
                List<Employee> employeeList = team.getEmployeeList();
                team.setEmployeeList(employeeList);
                return team;
            });
            return department;
        }).collect(Collectors.toList());

        return collect;
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
