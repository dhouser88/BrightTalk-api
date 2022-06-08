package com.brighttalk.controller;

import com.brighttalk.entity.Order;
import com.brighttalk.repository.OrderRepositoryResource;
import com.brighttalk.service.KafkaService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/api")
public class RestController {

    OrderRepositoryResource orderRepositoryResource;
    KafkaService kafkaService;

    public RestController(OrderRepositoryResource orderRepositoryResource, KafkaService kafkaService) {
        this.orderRepositoryResource = orderRepositoryResource;
        this.kafkaService = kafkaService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("test")
    public String hello() {
        return "working and live";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getOrders")
    public List<String> getOrders() {
        return orderRepositoryResource.get();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getOrderByID/{id}")
    public Response getOrderByID(@PathParam int id) {
        return orderRepositoryResource.getSingle(id);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("saveOrder")
    public Response saveOrder(Order order) {
       // kafkaService.sendOrderToKafka(order);

        return orderRepositoryResource.create(order);

    }


}

