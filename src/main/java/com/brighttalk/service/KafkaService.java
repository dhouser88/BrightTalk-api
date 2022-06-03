package com.brighttalk.service;

import com.brighttalk.entity.Order;
import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.stream.Stream;


@ApplicationScoped
public class KafkaService {
    @Inject
    @Channel("brighttalk-topic")
    Emitter<Record<String, String>> emitter;

    public void sendOrderToKafka(Order order) {
        emitter.send(Record.of(order.getOrderID(), order.toString()));
    }
    @Incoming("transactions")
    public void transactions(Order order) {
       // log.infof("New: %s", order);
    }

}
