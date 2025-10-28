package com.example.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

    @Autowired
    private Engine engine;

    public void start() {
        System.out.println("🚗 Car is starting...");
        engine.run();
    }
}
