package respository;

import model.Order;
import model.OrderLock;
import model.OrderStatus;

import java.util.*;

public class OrderRepository {

    private static OrderRepository instance;

    Map<String, Set<Order>> userOrderMap;

    private OrderRepository(){
        userOrderMap= new HashMap<>();
    }


    public static OrderRepository instance(){
        if(instance==null){
            instance = new OrderRepository();
        }
        return instance;
    }

    public String placeOrder(Order order,String userId) {
        if(!userOrderMap.containsKey(userId)){
            userOrderMap.put(userId,new HashSet<>());
        }
        userOrderMap.get(userId).add(order);
        order.setStatus(OrderStatus.ONTRANSIT);

        //put lock on object
        order.setOrderLock(new OrderLock(order.getOrderId(),System.currentTimeMillis()));
        // to address timeOut optionfor lock to release

        return  order.getOrderId();
    }

    public void cancelOrder(String orderid) {

        Optional<Order> orderTocancel =
        userOrderMap.entrySet().stream().flatMap(order ->order.getValue().stream()).filter(o ->o.getOrderId().equals(orderid))
                .findAny();

        if(orderTocancel.isPresent()){ // check for lock
            orderTocancel.get().setStatus(OrderStatus.CANCEL);
            orderTocancel.get().getProducts().stream()
                            .forEach(product -> product.setLocked(false));

            orderTocancel.get().setOrderLock(null); // nullify the lock
        }

       System.out.println("Order cancelled..");


    }
}
