package com.japroject.repository;

import com.japroject.model.NbaGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbaGameRepository extends JpaRepository<NbaGame, Long> {
}
