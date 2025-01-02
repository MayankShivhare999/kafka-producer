package com.example.kafka.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Message {
    private UUID id;
    private String content;
}
