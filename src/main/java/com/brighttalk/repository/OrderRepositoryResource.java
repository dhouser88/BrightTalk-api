package com.brighttalk.repository;

import com.brighttalk.entity.Order;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import io.quarkus.panache.common.Sort;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.List;

public class OrderRepositoryResource {
    @Inject
    OrderRepository orderRepository;

    @Inject
    Session session;

    private static final Logger LOGGER = Logger.getLogger(OrderRepositoryResource.class.getName());


    public List<Order> get() {
        return orderRepository.listAll(Sort.by("orderId"));
    }

    public Order getSingle(String id) {
        Order entity = null;
        String hql = "FROM Order O WHERE O.OrderId = :orderId";
        Query query = session.createQuery(hql);
        query.setParameter("orderId",id);
        List<Order> results = query.list();

        if(results.size() == 1){
            entity = results.get(0);
        }


        if (entity == null) {
            throw new WebApplicationException("Order with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    public Response create(Order order) {
        if (order.getOrderID() != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }

        orderRepository.persist(order);
        return Response.ok(order).status(201).build();
    }
}
