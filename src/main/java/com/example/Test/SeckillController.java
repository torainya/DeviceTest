package com.example.Test;

import com.example.demo.POJO.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SeckillController {
    @Autowired
    StringRedisTemplate redis;

    @RequestMapping(value = "/kill")
    public String kill(Device device) {


        long count = redis.opsForValue().decrement("1");
        if(count<0){
            count = redis.opsForValue().increment("1");
            System.out.println("秒杀失败，当前库存剩余量："+count);
        }
        else System.out.println("秒杀成功，当前库存剩余量："+count);

        return null;

    }
}


