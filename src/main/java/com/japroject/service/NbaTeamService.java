package com.japroject.service;

import com.japroject.model.NbaTeam;
import com.japroject.repository.NbaTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NbaTeamService {

    @Autowired
    private NbaTeamRepository nbaTeamRepository;

    public List<NbaTeam> findAllNbaTeams(){
        return nbaTeamRepository.findAll();
    }

    public void saveNbaTeam(NbaTeam nbaTeam){
        nbaTeamRepository.save(nbaTeam);
    }

}
