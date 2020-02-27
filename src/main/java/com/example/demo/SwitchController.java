package com.example.demo;


import com.example.demo.POJO.Device;
import org.springframework.web.bind.annotation.*;

@RestController
public class SwitchController {


    @RequestMapping(value = "/switch", method = RequestMethod.POST)
    public void Test(Device device) {

        System.out.println(device.getState());




    }
}
