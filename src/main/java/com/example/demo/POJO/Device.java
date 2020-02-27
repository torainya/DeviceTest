package com.example.demo.POJO;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Device {
    @Value("123") String id;
    @Value("123")String name;
    @Value("123")String value;
    @Value("123")String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Device(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = name;
    }
    public Device() {
        this.id = id;
        this.name = name;
        this.value = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
