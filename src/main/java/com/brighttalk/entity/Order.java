package com.brighttalk.entity;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    private Long id;

    @Id
    @SequenceGenerator(name = "orderSeq", sequenceName = "order_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "orderSeq")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private int orderID; // name colum
    private int customerID; //SELECT * FROM public.sale_order
   // private Address pickupAddress;
    //private Address destinationAddress;
    private int productID;
    private int quantity;
    //private String expectedDeliveryDate;
    private String status;

    private String orderNumber;

    private int partnerID;

    private int orderQuantityTotal;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public int getOrderQuantityTotal() {
        return orderQuantityTotal;
    }

    public void setOrderQuantityTotal(int orderQuantityTotal) {
        this.orderQuantityTotal = orderQuantityTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
