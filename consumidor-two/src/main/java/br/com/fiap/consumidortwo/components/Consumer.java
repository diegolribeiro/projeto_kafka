package br.com.fiap.consumidortwo.components;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.fiap.consumidortwo.domain.BolsaFamiliaModel;
import br.com.fiap.consumidortwo.services.ConsumerService;

@Component
public class Consumer {

    @Autowired
    private ConsumerService service;

    @KafkaListener(topics = "${consumertwo.topic}", groupId = "${consumertwo.group-id}")
    public void consume(final BolsaFamiliaModel consumerRecord) throws IOException {
        try {
            service.consume(consumerRecord);
        } catch (Exception e) {
            System.out.println("DEU ERRO: " + consumerRecord );
        }
    }
}