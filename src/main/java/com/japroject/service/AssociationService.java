package com.japroject.service;

import com.japroject.model.Association;
import com.japroject.repository.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationService {

    @Autowired
    private AssociationRepository associationRepository;

    public List<Association> findAllAssociations() {
        return associationRepository.findAll();
    }

    public void saveAssociation(Association association) {
        associationRepository.save(association);
    }
}
