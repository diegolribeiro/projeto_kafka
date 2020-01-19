package br.com.fiap.consumidortwo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import br.com.fiap.consumidortwo.domain.BolsaFamiliaModel;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, BolsaFamiliaModel> consumerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.99.101:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"br.com.fiap.consumidortwo");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
                new JsonDeserializer<>(BolsaFamiliaModel.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BolsaFamiliaModel> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
