package com.example.demo.POJO;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class Packet {
    String src;//源地址
    String dst;//目的地址
    String name;//包名
    String value;//变量值
    int level;//等级

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
