package com.japroject.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class TeamScore {
    private int win;
    private int loss;
    private Series series;
    private List<String> linescore;
    private int points;
}
