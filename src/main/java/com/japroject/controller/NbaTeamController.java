package com.japroject.controller;

import com.japroject.model.NbaTeam;
import com.japroject.model.User;
import com.japroject.service.NbaTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class NbaTeamController {

    @Autowired
    NbaTeamService nbaTeamService;

    @GetMapping("/nbateams")
    @ResponseBody
    public List<NbaTeam> getAllNbaTeams() {
        return nbaTeamService.findAllNbaTeams();
    }

    @PostMapping("/nbateam")
    public void addUser(@RequestBody NbaTeam nbaTeam) {
        nbaTeamService.saveNbaTeam(nbaTeam);
    }
}
