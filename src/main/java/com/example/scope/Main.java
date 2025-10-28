package com.example.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.example.scope")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
        SingleTonScope singleTonBean=context.getBean(SingleTonScope.class);
        SingleTonScope singleTonBean2=context.getBean(SingleTonScope.class);

        ProtoTypeScope protoTypeBean=context.getBean(ProtoTypeScope.class);
        ProtoTypeScope protoTypeBean1=context.getBean(ProtoTypeScope.class);

    }
}
