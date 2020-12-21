package com.example.Configuration;


import com.example.demo.POJO.Mytime;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.example.demo.CreateController.create*(*))")
    public void log() {//函数为空，仅代表定义了一个切点
    }

    @After(value = "log()")//设置切点，在方法成功调用后执行
    public void type() {
        System.out.println("Create new device successfully");
        System.out.println(Mytime.getTime());
    }


}
