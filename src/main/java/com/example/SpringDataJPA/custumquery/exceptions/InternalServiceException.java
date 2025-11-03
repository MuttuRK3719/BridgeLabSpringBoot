package com.example.SpringDataJPA.custumquery.exceptions;

public class InternalServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InternalServiceException(String message) {
        super(message);
    }
}