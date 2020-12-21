package com.example.Configuration;


import com.example.demo.POJO.Device;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MapConfig {

    @Bean
    public Map<String, Device> map(){
        return new HashMap<>();
    }
}
