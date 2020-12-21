package com.example.demo;


import com.example.demo.POJO.Device;
import com.example.demo.POJO.Person;
import com.example.demo.POJO.Router;
import com.example.demo.POJO.Sensor;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@RestController
public class CreateController {
    @Autowired
    Map<String, Device> map;
    @Autowired
    ExecutorService exe;

    @RequestMapping(value = "/newSensor", method = RequestMethod.POST)
    public void createNewSensor(@RequestParam("routerName") String routerName, Sensor sensor) {
        Router router = (Router) map.get(routerName);
        router.addSensor(sensor);
        map.put(sensor.getName(), sensor);

    }

    @RequestMapping(value = "/newRouter", method = RequestMethod.POST)
    public void createNewRouter(Router router) {
        exe.execute(router);
        map.put(router.getName(), router);
    }

    @RequestMapping(value = "/addTable", method = RequestMethod.POST)
    public void add(@RequestParam("cur") String cur,
                    @RequestParam("ip") String ip,
                    @RequestParam("next") String next) {
        Router curRouter = (Router) map.get(cur);
        Router nextRouter = (Router) map.get(next);
        curRouter.addTable(ip, nextRouter);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void add(@RequestParam("src") String src,
                    @RequestParam("dst") String dst
    ) {
        Sensor sensor = (Sensor) map.get(src);
        sensor.sendValue(dst);
    }

    @RequestMapping(value = "/getState", method = RequestMethod.POST)
    public int getState(String deviceName ) {
        Router router = (Router)map.get(deviceName);
        if(router!=null&&router.getState()!=null){
        return Integer.parseInt(router.getState());}
        return 0;
    }

    @RequestMapping(value = "/changeState")
    public String changeState(String routerName,String state) {
        Router router = (Router)map.get(routerName);
        router.setState(state);
        return "success";
    }

}
