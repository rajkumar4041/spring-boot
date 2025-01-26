package com.selfGroup.firstEmpCrud.repository;

import com.selfGroup.firstEmpCrud.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
