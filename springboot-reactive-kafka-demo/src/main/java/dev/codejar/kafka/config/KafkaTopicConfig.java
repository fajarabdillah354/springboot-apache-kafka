package dev.codejar.kafka.config;


import org.apache.kafka.clients.admin.NewPartitions;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic fajarTopic(){
        return TopicBuilder
                .name("fajar")
                .build();
    }


    @Bean
    public NewTopic ujehTopic(){
        return TopicBuilder
                .name("ujeh")
                .build();
    }



}
