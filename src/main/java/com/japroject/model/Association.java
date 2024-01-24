package com.japroject.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Association {

    @Id
    @GeneratedValue
    private Integer associationId;

    private String name;

    @ManyToMany(mappedBy = "associations")
    private List<User> users = new ArrayList<>();

    public Integer getId() {
        return associationId;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer associationId) {
        this.associationId = associationId;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Association(String name) {
        this.name = name;
    }

    public Association() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Association association = (Association) o;
        return Objects.equals(associationId, association.associationId) && Objects.equals(name, association.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(associationId, name);
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + associationId +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
