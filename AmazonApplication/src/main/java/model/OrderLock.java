package model;

public class OrderLock {

    String orderLockId;

    public OrderLock(String orderLockId, long lockAttainedTime) {
        this.orderLockId = orderLockId;
        this.lockAttainedTime = lockAttainedTime;
    }

    long lockAttainedTime;
}
