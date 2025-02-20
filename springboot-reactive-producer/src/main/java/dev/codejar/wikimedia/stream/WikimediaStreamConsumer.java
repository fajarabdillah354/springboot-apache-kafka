package dev.codejar.wikimedia.stream;


import dev.codejar.wikimedia.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.pattern.PathPattern;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    //contoh penggunaan WebClient pada springboot

    private final WebClient webClient;
    private final WikimediaProducer producer;

    public WikimediaStreamConsumer(WikimediaProducer producer, WebClient.Builder webClientBuilder) {
        this.producer = producer;
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
    }


    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }

}
