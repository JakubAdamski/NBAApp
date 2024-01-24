package com.japroject.controller;

import com.japroject.model.NbaGame;
import com.japroject.repository.NbaGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NbaGameController {

    private final NbaGameRepository nbaGameRepository;

    @Autowired
    public NbaGameController(NbaGameRepository nbaGameRepository) {
        this.nbaGameRepository = nbaGameRepository;
    }

    @GetMapping("/games")
    public List<NbaGame> getAllGames() {
        // Zwraca listę wszystkich gier z bazy danych
        return nbaGameRepository.findAll();
    }
}
