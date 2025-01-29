package com.selfGroup.firstEmpCrud.Controller;

import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Team;
import com.selfGroup.firstEmpCrud.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PutMapping("/addTeam")
    public Team addTeam(Team team) {
        return teamService.addTeam(team);
    }

    @PutMapping("/updateTeam")
    public Team udpateTeam(@RequestParam int id, @RequestBody Team team) {
        return teamService.udpateTeam(id, team);
    }


    @GetMapping("/getAllTeams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @DeleteMapping("/deleteTeam")
    public Team deleteTeam(@RequestParam int id) {
        return teamService.deleteTeam(id);
    }


    @GetMapping("/getMyDepartment")
    public Department getMyDepartment(@RequestParam int teamId) {
        return teamService.getMyDepartment(teamId);
    }


}
