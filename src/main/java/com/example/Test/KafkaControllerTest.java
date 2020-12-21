package com.example.Test;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
public class KafkaControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(KafkaControllerTest.class);
    @Autowired
    private KafkaTemplate kafkaTemplate;


    @RequestMapping("test/produce")
    public String produce(String msg) {
        logger.info("msg is {}", msg);
        ProducerRecord producerRecord = new ProducerRecord("demo", "msg", msg);
        kafkaTemplate.send(producerRecord); //使用kafka模板发送信息
        return "success";
    }

    @RequestMapping(value = "kafka/topic")
    public void createNewTopic(String topic) {
        NewTopic newTopic = new NewTopic(topic, 10, (short) 2);
        List<NewTopic> newTopics = new ArrayList<>();
        try {
            //todo
            //kafkaAdmin.createTopics(newTopics);
            System.out.println();
            logger.info("kafkaTopic created success!");
        } catch (Exception e) {
            logger.info("kafkaTopic created failed!");
        }


    }

    //@KafkaListener(topics = "demo")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }
}