package com.japroject.service;

import org.springframework.beans.factory.annotation.Autowired;

public class test {

    @Autowired
    ApiService apiService;

    public void main(String[] args) {
        apiService.fetchAndSaveGames("2023");

    }
}
