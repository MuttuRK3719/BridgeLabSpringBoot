package com.example.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Qualifier("dieselEngine")
    @Autowired
    private Engine engine;
    void  start(){
        System.out.println("Car is started ");
        engine.engineType();
    }
}
