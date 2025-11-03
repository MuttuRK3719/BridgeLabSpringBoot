package com.example.SpringDataJPA.example.exceptions;

public class PetNotFoundException extends Exception{

    public PetNotFoundException(String message) {
        super(message);
    }
}
