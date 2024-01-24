package com.japroject;

import com.japroject.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NbaAppAplication {


    public static void main(String[] args) {
        SpringApplication.run(NbaAppAplication.class, args);

    }


}
