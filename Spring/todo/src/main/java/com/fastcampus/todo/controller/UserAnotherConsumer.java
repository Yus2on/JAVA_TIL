package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAnotherConsumer implements MessageListener<String, UserDto> {

    @Override
    @KafkaListener(topics = "user", groupId = "consumer-2")
    public void onMessage(ConsumerRecord<String, UserDto> data) {
        System.out.println(data.key());
        System.out.println(data.value());
    }
}
