package com.japroject.exception;

public class AssociationNotFoundException extends RuntimeException{
    public AssociationNotFoundException(Integer id){
        super("Could not find the association with id: " + id);
    }
}
