package com.example.demo.POJO;

import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Random;

@Component
public class Producer extends Thread  {

    @Override
    public void run() {
        try {while(true){
            Packet packet = new Packet();
            packet.setDst(InetAddress.getLocalHost().getAddress()+"");
            packet.setSrc(InetAddress.getLocalHost().getAddress()+"");
            packet.setValue(new Random(100)+"");
            Thread.sleep(5000);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
