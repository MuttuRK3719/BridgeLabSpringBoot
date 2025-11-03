package com.example.SpringDataJPA.custumquery.exceptions;

public class PetNotFoundException extends Exception{

    public PetNotFoundException(String message) {
        super(message);
    }
}
