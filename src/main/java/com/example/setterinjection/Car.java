package com.example.setterinjection;

public class Car {
    private String model;
    private Engine engine;

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("🚗 " + model + " is starting...");
        engine.run();
    }
}