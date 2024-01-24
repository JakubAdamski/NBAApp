package com.japroject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class NbaGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int season;
    private LocalDateTime gameDate;
    private String gameStatus;
    private String homeTeamName;
    private String homeTeamLogoUrl;
    private String homeTeamCode;
    private Integer homeTeamPoints;
    private String visitorTeamName;
    private String visitorTeamLogoUrl;
    private String visitorTeamCode;
    private Integer visitorTeamPoints;

}

