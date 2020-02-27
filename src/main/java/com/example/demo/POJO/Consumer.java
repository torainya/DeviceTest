package com.example.demo.POJO;

import org.springframework.stereotype.Component;

@Component
public class Consumer extends Thread  {

    @Override
    public void run() {
        try {while(true){
            System.out.println("consume..");
            Thread.sleep(1000);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
