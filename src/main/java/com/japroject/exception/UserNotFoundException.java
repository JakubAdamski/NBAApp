package com.japroject.exception;

import jakarta.persistence.criteria.CriteriaBuilder;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer id) {
        super("Could not find the user with id: " + id);
    }
}
