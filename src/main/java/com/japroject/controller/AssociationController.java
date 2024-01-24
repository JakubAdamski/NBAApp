package com.japroject.controller;

import com.japroject.model.Association;
import com.japroject.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AssociationController {

    @Autowired
    AssociationService associationService;

    @GetMapping("/associations")
    @ResponseBody
    public List<Association> getAllAssociations() {
        return associationService.findAllAssociations();
    }

    @PostMapping("/association")
    public void addAssociation(@RequestBody Association association) {
        associationService.saveAssociation(association);
    }


}
