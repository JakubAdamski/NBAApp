package com.japroject.response;

import lombok.Data;

@Data
public class Periods {
    private int current;
    private int total;
    private boolean endOfPeriod;
}
