package com.example.demo.POJO;

public class Sensor extends Device {
    private Router router;
    private String value;

    public Sensor(String name) {
        this.setName(name);
    }

    public Sensor() {
    }


    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public String getValue() {
        return String.valueOf((int) (Math.random() * 1000));
    }

    public void setValue(String value) {

        this.value = value;
    }


    public void sendValue(String dst, String value, int level) {
        Packet packet = new Packet();
        packet.setDst(this.ip);
        packet.setSrc(dst);
        packet.setValue(this.getValue());
        packet.setLevel(level);
        router.putPacket(packet, this.ip);
        System.out.println(this.ip + "成功发送信息,信息内容为：" + packet.getValue());
    }

    public void sendValue(String dst) {
        Packet packet = new Packet();
        packet.setDst(dst);
        packet.setSrc(this.ip);
        packet.setValue(this.getValue());
        packet.setLevel(1);
        System.out.println(this.ip + "发送信息,信息内容为：" + packet.getValue()
                + " ,目的地为 " + packet.getDst());
        router.putPacket(packet, this.ip);

    }

    public void recieve(Packet packet) {
        System.out.println(this.ip + " 成功收到来自：" + packet.getSrc()
                + " 的消息,收到的信息为：" + packet.getValue()
        );
    }


}
