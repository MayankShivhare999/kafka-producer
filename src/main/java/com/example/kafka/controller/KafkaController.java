package com.example.kafka.controller;

import com.example.kafka.dao.Message;
import com.example.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kafka-send")
public class KafkaController {

    @Value("${kafka.topic.message}")
    private String MESSAGE_TOPIC;

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/message")
    public String sendMessage(@RequestParam String message) {
        Message messageObj = new Message();
        messageObj.setId(UUID.randomUUID());
        messageObj.setContent(message);
        kafkaProducer.publish(MESSAGE_TOPIC, messageObj);
        return "Message sent!";
    }
}
