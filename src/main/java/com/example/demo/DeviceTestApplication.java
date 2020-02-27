package com.example.demo;

import com.example.demo.POJO.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@SpringBootApplication
@RequestMapping(value = "/")
public class DeviceTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(DeviceTestApplication.class, args);


    }




}
