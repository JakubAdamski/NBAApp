package com.japroject.repository;

import com.japroject.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociationRepository extends JpaRepository<Association,Long> {

    Optional<Association> findById(Integer id);
}
