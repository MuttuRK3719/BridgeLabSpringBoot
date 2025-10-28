package com.example.constructorinjection;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("Car class constructor is created and engine bean is injected");
    }

    public void start() {
        System.out.println("Car is starting");
        engine.condition();
    }
}
