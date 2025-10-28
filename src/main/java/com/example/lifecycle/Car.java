package com.example.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @PostConstruct
    public void init() {
        System.out.println("🔧 Car bean is initialized.");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("🧹 Car bean is about to be destroyed.");
    }
    public void start() {
        System.out.println("🚗 Car is starting...");
    }
}
