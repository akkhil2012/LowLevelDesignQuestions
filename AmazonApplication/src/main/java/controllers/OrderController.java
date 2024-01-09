package controllers;

import model.Address;
import model.Order;
import model.Product;
import respository.ProductRepository;
import service.OrderService;
import service.OrderServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class OrderController {


    ProductService productService;

    public OrderController() {
        ProductRepository.instance();
        this.productService = new ProductServiceImpl();
        this.orderService = new OrderServiceImpl();
    }

    OrderService orderService;

    public String placeOrder(List<String> products, int count, Address address,String userId){
       // List<Product> products = new ArrayList<>();
        List<String> productsAvailable = new ArrayList<>();

        //call product service: to check inventory:if available than lock
        for(String p : products) {
            if(productService.isStockAvailable(p)){
                productsAvailable.add(p);
            }

        }

        System.out.println(" Available products are :  ");
        productsAvailable.stream().forEach(System.out::println);

        //Place bulk order
        Order order = new Order(productsAvailable,address);
        orderService.placeOrder(order,userId);

        return order.getOrderId();


    }

    public void cancelOrder(String orderid) {
        orderService.cancelOrder(orderid);
    }
}

