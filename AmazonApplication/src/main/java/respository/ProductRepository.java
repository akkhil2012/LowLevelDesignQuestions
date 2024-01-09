package respository;

import model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductRepository {

    private static ProductRepository instance;

    Map<String,Product> products;

    Lock lockToAddProductToCart;

    Map<String, Set<Product>> userProductMap;

    private ProductRepository(){
        userProductMap= new HashMap<>();
        lockToAddProductToCart = new ReentrantLock();
        products = new HashMap<>();
        products.put("1", new Product());
        products.put("2", new Product());
        products.put("3", new Product());
    }


    public static ProductRepository instance(){
        if(instance==null){
            instance = new ProductRepository();
        }
        return instance;
    }

    public boolean findProductIfAvailable(String productId) {
        boolean isAvialable;
        lockToAddProductToCart.lock();
        if(!products.containsKey(productId))
            return  false;
        isAvialable=products.get(productId).isLocked();
        products.get(productId).setLocked(true);
        lockToAddProductToCart.unlock();
        return  !isAvialable;
    }
}
