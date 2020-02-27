package com.example.demo.POJO;

import org.springframework.stereotype.Component;

import java.util.concurrent.PriorityBlockingQueue;
@Component
public class PacketQueue {
    private static PriorityBlockingQueue<Packet> queue = new PriorityBlockingQueue<Packet>(5);

    public void putPacket(Packet packet) {
        queue.put(packet);
        System.out.println("Send Successfully,the queue remains " + queue.remainingCapacity());
    }

    public Packet takePacket() {
        try {
            return queue.take();
        } catch (Exception e) {
            System.out.println("Queue Interrupted!");
            return null;
        }
    }
}

