package model;

import java.util.*;

public class Order {
    public void setOrderLock(OrderLock orderLock) {
        this.orderLock = orderLock;
    }


    private String orderId;

    public List<Product> getProducts() {
        return products;
    }

    List<Product> products;

    List<String> productIds;

    OrderLock orderLock;// to determine the lock for which Object and for what time

    public String getOrderId() {
        return orderId;
    }

    private Address address;

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    OrderStatus status;


    public Order(List<String> productId,Address address) {
        this.orderId = UUID.randomUUID().toString();
        this.productIds = productId;
        this.address = address;
        this.status=OrderStatus.IDLE;
        this.products = new ArrayList<>();
    }
}
