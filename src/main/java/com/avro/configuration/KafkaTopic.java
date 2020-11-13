package com.avro.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopic {

    @Bean
    public NewTopic employeGeneralInformationTopic() {
        return TopicBuilder.name("customer_topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
