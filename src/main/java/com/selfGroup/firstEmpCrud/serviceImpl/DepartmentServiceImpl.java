package com.selfGroup.firstEmpCrud.serviceImpl;


import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Employee;
import com.selfGroup.firstEmpCrud.model.Team;
import com.selfGroup.firstEmpCrud.repository.DepartmentRepository;
import com.selfGroup.firstEmpCrud.repository.TeamRepository;
import com.selfGroup.firstEmpCrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Department addDepartment(Department department) {
        // Iterate through teams and set the department reference
        List<Team> teams = department.getTeams();
        if (teams != null) {
            teams.forEach(team -> {
                team.setDepartment(department);
                team.getEmployeeList().forEach(employee -> employee.setTeam(team));
            });
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


    public ResponseEntity<List<Department>> getAllDepartment() {
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

        if (collect.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(collect));
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

    public Department addTeamWithEmployee(int departmentId, int empId) {
        Optional<Team> optionalTeam = teamRepository.findById(empId);

        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);

        if (optionalTeam.isPresent() && optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            Team team = optionalTeam.get();

            team.setDepartment(department);
            teamRepository.save(team);

            List<Team> teams = department.getTeams();
            teams.add(team);


            System.out.println("Updated Department: >>>>>>>>>>>>>i>>>>>>>>>>>>>>>>>>>>>>>" + teams + "team>" + team);
            department.setTeams(teams);

            departmentRepository.save(department);

            System.out.println("Updated Department: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + department);
            return department;
        }


        return null;
    }

}
