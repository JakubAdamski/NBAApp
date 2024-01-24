package com.japroject.repository;

import com.japroject.model.NbaTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbaTeamRepository extends JpaRepository<NbaTeam, Long> {
}
