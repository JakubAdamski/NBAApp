package com.japroject.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
public class Status {
    private String clock;
    private boolean halftime;
    private int _short;

    private String _long;
}