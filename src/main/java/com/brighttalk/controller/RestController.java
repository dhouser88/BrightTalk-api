package com.brighttalk.controller;

import com.brighttalk.service.OrderService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/api")
public class RestController {

    OrderService orderService;

    public RestController(OrderService orderService) {
        this.orderService = orderService;
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
    public String getOrders() {
        return "";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getOrderByID")
    public String getOrderByID() {
        return "";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("saveOrder")
    public String saveOrder() {
        return "";
    }


}

