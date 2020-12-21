package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

@EnableScheduling
@SpringBootApplication
@RequestMapping(value = "/")
public class DeviceTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(DeviceTestApplication.class, args);
        System.out.println("启动成功");

    }


}
