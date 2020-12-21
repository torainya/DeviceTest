package com.example.demo.POJO;

public class Packet implements Comparable<Packet> {
    String src;//源地址 ipv4
    String dst;//目的地址 ipv4
    int id;//包序号 一般为设备名
    String value;//变量值 设备发出的示数
    int level;//等级 优先级等级

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(Packet o) {
        return o.getLevel() - this.level;

    }


}
