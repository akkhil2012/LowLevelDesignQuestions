package service;

import model.Order;

import java.util.List;

public interface OrderService {

    String placeOrder(Order order,String userId);

    String placeOrder(List<Order> order,String userId);

    void cancelOrder(String orderid);
}
