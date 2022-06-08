package com.brighttalk.service;

import com.brighttalk.entity.Order;
import com.google.gson.Gson;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class KafkaService {
    @Inject
    @Channel("outgoingorders")
    Emitter<Record<String, String>> emitter;


    public void sendOrderToKafka(Order order) {
        Gson gson = new Gson();
        emitter.send(Record.of(order.getOrderID()+ "", gson.toJson(order)));
    }

}
