package com.brighttalk.controller;

import com.brighttalk.entity.Order;
import com.brighttalk.repository.OrderRepositoryResource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/api")
public class RestController {

    OrderRepositoryResource orderRepositoryResource;

    public RestController(OrderRepositoryResource orderRepositoryResource) {
        this.orderRepositoryResource = orderRepositoryResource;
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
    public List<Order> getOrders() {
        return orderRepositoryResource.get();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getOrderByID")
    public Order getOrderByID(String id) {
        return orderRepositoryResource.getSingle(id);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("saveOrder")
    public Response saveOrder(Order order) {
        return orderRepositoryResource.create(order);
    }


}

