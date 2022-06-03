package com.brighttalk.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.ws.rs.GET;
import java.util.List;

@Entity
@Cacheable
@Table(name="user")
public class Order extends PanacheEntity {
    @Id
    @Column(name="id")
    private int id;
    @NaturalId
    @Column(name="email")
    private String orderID;
    private String customerID;
    private Address pickupAddress;
    private Address destinationAddress;
    private String productID;
    private String quantity;
    private String expectedDeliveryDate;
    private String status;



    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Address getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(Address pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public Address getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(Address destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
