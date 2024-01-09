package service;

import model.Order;
import model.Product;

public interface ProductService {

    boolean isStockAvailable(String productId);

    void moveToCart(Product product);

}
