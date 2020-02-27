package com.example.demo;


import com.example.demo.POJO.Device;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateController {


    @RequestMapping(value = "/newDevice", method = RequestMethod.POST)
    public void CreateNewDevice(Device device) {
        System.out.println("New Device Created,id:"+
                device.getId()+",name:"+device.getName());



    }
}
