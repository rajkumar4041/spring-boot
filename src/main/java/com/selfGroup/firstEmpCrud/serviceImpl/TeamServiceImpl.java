package com.selfGroup.firstEmpCrud.serviceImpl;

import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Team;
import com.selfGroup.firstEmpCrud.repository.EmployeeRepository;
import com.selfGroup.firstEmpCrud.repository.TeamRepository;
import com.selfGroup.firstEmpCrud.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {


    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team udpateTeam(int id, Team team) {
        Optional<Team> byId = teamRepository.findById(id);
        return byId.map((t) ->
                teamRepository.save(t)
        ).orElse(null);
    }


    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team deleteTeam(int id) {
        Optional<Team> byId = teamRepository.findById(id);
        teamRepository.deleteById(id);
        return byId.orElse(null);
    }

    public Department getMyDepartment(int teamId) {

        Optional<Team> byId = teamRepository.findById(teamId);

        return byId.map(Team::getDepartment).orElse(null);
    }


}
