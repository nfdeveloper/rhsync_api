package com.nfsystems.rhsync_api.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nfsystems.rhsync_api.marking.dto.MarkingPublisherRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MarkingPublisher {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${marking.config.kafka.topics.marking}")
    private String topic;

    public void publish(MarkingPublisherRequest markingPublisher){
        try {
            var json = objectMapper.writeValueAsString(markingPublisher);
            kafkaTemplate.send(topic, "data", json);
        } catch (JsonProcessingException ex){
            log.error("Erro ao processar JSON", ex);
        } catch (RuntimeException e){
            log.error("Erro ao publicar no tópico de marcações", e);
        }
    }
}
