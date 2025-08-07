package dev.codejar.kafka.producer;

import dev.codejar.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student){
        Message<Student> studentMessage = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "fajar")
                .build();

        kafkaTemplate.send(studentMessage);
    }


}
