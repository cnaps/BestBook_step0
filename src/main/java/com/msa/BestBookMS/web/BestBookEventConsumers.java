package com.msa.BestBookMS.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.BestBookMS.domain.model.evnet.ItemRented;
import com.msa.BestBookMS.service.BestBookService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class BestBookEventConsumers {

    private final Logger log = LoggerFactory.getLogger(BestBookEventConsumers.class);
    public static final  String  TOPIC = "topic_kafka";
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final BestBookService bestBookService;

    @KafkaListener(topics="exam",groupId = "foo4")
    public void consume(ConsumerRecord<String, String> record) throws IOException{
        System.out.printf(record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        bestBookService.dealBestBook(itemRented.getItem());
    }
}
