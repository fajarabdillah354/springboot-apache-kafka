# springboot-apache-kafka


## Async Messaging with Apache Kafka

I received the following question from a YouTube subscriber and I thought it was a good one to answer:

> Could you provide a video covering how to use Apache Kafka for asynchronous messaging? And if possible, how to do unit tests as well, as that would be very helpful!

## Getting Started
To set up an Apache Kafka project, you need to install Kafka and Zookeeper. You can use [Confluent Kafka](https://www.confluent.io/) for an easy setup or run Kafka locally using Docker.

## Kafka Producer and Consumer
Apache Kafka is used for event-driven applications, where producers send messages to topics and consumers subscribe to those topics.

### Kafka Producer Example
```java
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
```

### Kafka Consumer Example
```java
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "group_id")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
```

## Writing Tests for Kafka
These are the different tests I have written for the Kafka producer and consumer and what they are used for.

### KafkaProducerTest
Unit testing the Kafka producer using a mocked KafkaTemplate to verify messages are sent correctly.

### KafkaConsumerTest
A better approach is to use an embedded Kafka server to simulate the actual environment and test the message flow.

Thanks to **Confluent** for providing great Kafka resources and documentation.

### KafkaIntegrationTest
Use an embedded Kafka instance with Spring Boot to perform full end-to-end testing.

## Conclusion
Kafka is a powerful tool for building event-driven architectures, and proper testing ensures reliable message processing. Happy coding!

