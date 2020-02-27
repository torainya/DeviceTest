package com.example.demo;

import com.example.demo.POJO.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    @RequestMapping(value = "/getValue", method = RequestMethod.POST)

    public String CreateNewDevice(String deviceName) {
        System.out.println("收到"+deviceName+"读取请求");
        if(deviceName.equals("温度计"))
        return (int)(20+Math.random()*8)+"℃";
        if(deviceName.equals("分贝计"))
            return (int)(Math.random()*100)+"B";
        return "获取信息失败";
    }
}
