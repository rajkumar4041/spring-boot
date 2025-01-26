package com.selfGroup.firstEmpCrud.service;

import com.selfGroup.firstEmpCrud.model.Department;
import com.selfGroup.firstEmpCrud.model.Team;

import java.util.List;

public interface TeamService {


    public Team addTeam(Team team);

    public Team udpateTeam(int id, Team team);

    public List<Team> getAllTeams();

    public Team deleteTeam(int id);

    public Department getMyDepartment(int teamId);
}
