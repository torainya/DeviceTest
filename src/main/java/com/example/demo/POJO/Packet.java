package com.example.demo.POJO;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class Packet   {
    String src;
    String dst;
    String value;


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
