package com.example.demo.POJO;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Task {
    @Async
    public void sayHello(String name) {
        System.out.println("hello");
    }
}