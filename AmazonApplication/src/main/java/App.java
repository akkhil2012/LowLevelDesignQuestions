import controllers.OrderController;
import model.Address;
import model.Product;
import service.OrderService;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void  main(String args[]){

        OrderController orderController = new OrderController();

        Address address = new Address("",1,"");

        //for(int i=0;i<2;i++){
            String orderid = orderController.placeOrder(Arrays.asList("1","2"),1,address,"1");
            System.out.println("Order placed.........for products 1 and 2 with Order ID  "+ orderid);
        //}

        // cancel order
         orderController.cancelOrder(orderid);




        System.out.println("CancelOrder.................");
        orderController.placeOrder(Arrays.asList("1","2","3"),1,address,"1");
        System.out.println(" All orders by users");


        System.out.println("Try to order the same product again.....");
        orderid = orderController.placeOrder(Arrays.asList("1","2"),1,address,"1");
        System.out.println("Order placed.........for products 1 and 2 with Order ID : again "+ orderid);




    }
}
