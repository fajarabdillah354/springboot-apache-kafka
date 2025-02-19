package dev.codejar.wikimedia.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(topics = "wikimedia-stream", groupId = "myCodejar")
    public void consumedMessage(String message){
        log.info("Consuming the message from wikimedia-stream topic:: {}", message);
        //Please feel free to do anything you want with the data
    }
}
