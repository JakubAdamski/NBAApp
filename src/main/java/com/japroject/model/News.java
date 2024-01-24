package com.japroject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class News {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String contents;
    private String author;


}
