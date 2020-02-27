package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeviceTestApplicationTests {
    @Autowired
    private Person person1;
    @Autowired
    private Person person2;

    @Test
    void contextLoads() {
        System.out.println(person1.getId());
        System.out.println(person2.getId());




    }


}
