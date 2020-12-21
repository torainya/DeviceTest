package com.example.demo;

import com.example.demo.POJO.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    @RequestMapping(value = "/getValue", method = RequestMethod.POST)

    public String getValue(String deviceName) {

        return (int)(Math.random()*100)+"";

    }
}
