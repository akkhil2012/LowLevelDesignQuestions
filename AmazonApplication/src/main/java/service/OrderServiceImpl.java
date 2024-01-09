package service;

import model.Order;
import respository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements  OrderService{

    OrderRepository repository;
    public OrderServiceImpl(){
        OrderRepository repository = OrderRepository.instance();
    }


    @Override
    public String placeOrder(Order order,String userId) {
        repository = OrderRepository.instance();
        // placeorder and change sattus
        return repository.placeOrder(order,userId);
    }


    //>> Bulk API
    @Override
    public String placeOrder(List<Order> order,String userId) {
        return null;
    }

    @Override
    public void cancelOrder(String orderid) {
        repository.cancelOrder(orderid);
    }
}
