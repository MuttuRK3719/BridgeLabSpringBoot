package com.example.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class SingleTonScope {
    private static int count;

    public SingleTonScope() {
        count++;
        System.out.println("Singleton bean is created " + count);
    }
}
