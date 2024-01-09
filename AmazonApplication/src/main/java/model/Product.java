package model;

import java.util.UUID;

public class Product {

    private boolean isLocked;

    private String productId;

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Product() {
        this.productId = UUID.randomUUID().toString();
        this.isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
