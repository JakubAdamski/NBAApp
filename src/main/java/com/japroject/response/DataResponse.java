package com.japroject.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataResponse {

    private int id;
    private String league;
    private int season;


    @JsonProperty("date")
    private _Date _date;
    private int stage;
    private Status status;
    private Periods periods;
    private Arena arena;
    private Teams teams;
    private Scores scores;
    private List<Object> officials; // Tutaj można dostosować typ danych dla officials, jeśli są dostępne
    private Integer timesTied; // Tutaj można dostosować typ danych dla timesTied, jeśli jest dostępny
    private Integer leadChanges; // Tutaj można dostosować typ danych dla leadChanges, jeśli jest dostępny
    private Object nugget;

}
