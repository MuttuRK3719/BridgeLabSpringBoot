package com.example.annotation;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine {
    @Override
    public void engineType() {
        System.out.println("Diesel Engine");
    }
}
