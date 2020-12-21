package com.example.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


//@Component
//@Configuration
public class SimpleJob {

    @Scheduled(cron = "0/2 * * * * ?" )
    public void pull(){

        System.out.println("state changed");
    }

}
