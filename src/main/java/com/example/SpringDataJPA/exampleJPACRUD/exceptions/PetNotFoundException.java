package com.example.SpringDataJPA.exampleJPACRUD.exceptions;

public class PetNotFoundException extends Exception{

    public PetNotFoundException(String message) {
        super(message);
    }
}
