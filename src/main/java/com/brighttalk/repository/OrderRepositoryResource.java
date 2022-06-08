package com.brighttalk.repository;

import com.brighttalk.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import io.quarkus.panache.common.Sort;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OrderRepositoryResource {
    @Inject
    OrderRepository orderRepository;
    @Inject
    EntityManagerFactory entityManagerFactory;

    private static final Logger LOGGER = Logger.getLogger(OrderRepositoryResource.class.getName());


    public List<String> get() {
        Gson gson = new Gson();
        List<String> orderJsons = new ArrayList<>();
        List<Order>  orders = orderRepository.listAll(Sort.by("orderId"));
        for(Order o : orders){
            orderJsons.add(gson.toJson(o));
        }
        return orderJsons;
    }

    public Response getSingle(int id) {
        Gson gson = new Gson();
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT o FROM Order o WHERE o.orderID = :orderid");
        query.setParameter("orderid", id);
        Order result = (Order) query.getSingleResult();
        em.close();
        return Response.ok(gson.toJson(result)).status(200).build();
    }

    @Transactional
    public Response create(Order order) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.merge(order);
        em.close();
        //em.persist(order);
        //orderRepository.persist(order);

        return Response.ok(order).status(201).build();
    }
}
