package com.example.annotation;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine{
    @Override
    public void engineType() {
        System.out.println("Petrol Engine");
    }
}
