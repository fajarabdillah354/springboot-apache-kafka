package dev.codejar.kafka.consumer;


import dev.codejar.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "ujeh", groupId = "myCodejar")
    public void consumedMessage(String message){
        log.info("Consuming the message from ujeh topic :: {}", message);
    }

    @KafkaListener(topics = "fajar", groupId = "myCodejar")
    public void consumeJsonMessage(Student student){
        log.info("Consuming the message from fajar topic:: {}", student.toString());
    }


}
