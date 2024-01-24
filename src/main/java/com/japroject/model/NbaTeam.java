package com.japroject.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class NbaTeam {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String teamColors;
    private String conference;
    private String division;
    private Integer year;
    private String arena;
    private String location;
    private String president;
    private String generalManager;
    private String headCoach;
//    @ElementCollection
//    private List<Integer> championships;
//    @ElementCollection
//    private List<Integer> conferenceTitles;
//    @ElementCollection
//    private List<Integer> divisionTitles;
//    @ElementCollection
//    private List<Integer> retiredNumbers;


}
