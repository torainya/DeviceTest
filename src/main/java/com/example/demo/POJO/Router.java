package com.example.demo.POJO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class Router extends Device implements Runnable {

    private PriorityBlockingQueue<Packet> queue = new PriorityBlockingQueue<Packet>(5);
    private Map<String, Router> table = new ConcurrentHashMap<>();
    private Map<String, Sensor> local = new ConcurrentHashMap<>();
    private int ipid = 2;
    private String network;

    public Router(String name, String network) {
        this.setName(name);
        this.setNetwork(network);
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void putPacket(Packet packet, String name) {
        queue.put(packet);
        System.out.println("路由 " + this.name + " 收到来自 " + name + " 的信息");
    }

    public void takePacket() {
        try {
            Packet packet = queue.take();
            String ip = packet.getDst();
            Sensor s = local.getOrDefault(ip, null);
            if (s != null) {
                s.recieve(packet);
            } else {
                Router router = table.getOrDefault(ip, null);
                if (router != null) {
                    System.out.println("目的地址: " + ip + " 不在 " + this.name + " 中，将转发至 "
                            + router.getName());
                    router.putPacket(packet, this.getName());
                } else {
                    System.out.println("目的设备无法找到！");
                }


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

    public Packet peek() {
        return queue.peek();
    }

    public void showAllSensors() {
        System.out.println("******" + this.getName() + "的端口列表如下：******");
        for (Map.Entry<String, Sensor> entry : local.entrySet()) {
            Sensor sensor = entry.getValue();
            System.out.println(sensor.getName() + " 的IP为：" + sensor.getIp() + " 设备状态为：" + sensor.getState());
        }
    }

    public void showSensor(String ip) {
        Sensor sensor = local.get(ip);
        if (sensor != null) {
            System.out.println(sensor.getName() + "设备状态为：" + sensor.getState());
        } else {
            System.out.println("查询IP为：" + ip + " 失败,该设备不在 " + this.getName() + " 中");
        }
    }

    public void addSensor(Sensor sensor) {
        String ip = network.substring(0, network.length() - 1) + ipid;
        ipid++;
        sensor.setRouter(this);
        sensor.setIp(ip);
        System.out.println(sensor.getName() + " IP已设置为：" + sensor.getIp());
        local.put(ip, sensor);
    }

    public void addTable(String ip, Router router) {
        table.put(ip, router);
    }

    public void showTable() {
        System.out.println("******" + this.getName() + "转发表如下：******");
        for (Map.Entry<String, Router> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getName());
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.takePacket();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

