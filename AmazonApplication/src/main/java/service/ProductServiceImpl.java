package service;

import model.Product;
import respository.ProductRepository;

public class ProductServiceImpl implements  ProductService{


   // ProductRepository productRepository;

    @Override
    public boolean isStockAvailable(String productId) {
        return  ProductRepository.instance().findProductIfAvailable(productId);
    }

    @Override
    public void moveToCart(Product product) {

    }
}
