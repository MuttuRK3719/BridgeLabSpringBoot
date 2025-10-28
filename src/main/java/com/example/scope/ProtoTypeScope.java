package com.example.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProtoTypeScope {
    private static int count;

    public ProtoTypeScope() {
        count++;
        System.out.println("ProtoType bean is created " + count);
    }
}
