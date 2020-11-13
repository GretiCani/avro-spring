package com.avro.controller;

import com.avro.Customer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class ProducerController implements CommandLineRunner {


    @Autowired
    KafkaTemplate<String, Customer> template;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 10 ; i<3000; i++){
            Customer customer = Customer.newBuilder().setFirstName("Customer_"+i).setLastName("lastname_"+i).setAge(25+i).setHeight(180+i).setWeight(70+i).build();
            template.send("customer_topic",customer);
        }


    }


    @KafkaListener(topics = "customer_topic")
    public void print(ConsumerRecord<String, Customer> record){
        System.err.println(record.value());
    }




}
