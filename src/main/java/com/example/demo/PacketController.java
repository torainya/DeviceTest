package com.example.demo;

import com.example.demo.POJO.Device;
import com.example.demo.POJO.Packet;
import com.example.demo.POJO.PacketQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacketController {
    @Autowired
    PacketQueue queue;

    @RequestMapping(value = "/sendPacket", method = RequestMethod.POST)
    public void Send(Packet packet) {
        queue.putPacket(packet);
    }

    @RequestMapping(value = "/recivePacket", method = RequestMethod.POST)
    public Packet Recive() throws InterruptedException {
        return queue.takePacket();
    }
}
