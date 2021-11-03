package com.database.ormlibrary.order;

import javax.persistence.Embeddable;
import java.time.ZonedDateTime;

@Embeddable
public class OrderTimeEntity {
    private ZonedDateTime placed; //renamed order_accept to placed
    private ZonedDateTime restaurantAccept;
    private ZonedDateTime restaurantStart;
    private ZonedDateTime restaurantComplete;
    private ZonedDateTime driverAccept;
    private ZonedDateTime driverComplete;
    private ZonedDateTime orderComplete;
    private ZonedDateTime deliverySlot; //beginning of time slot, includes 10 minutes afterwards

    public ZonedDateTime getPlaced() {
        return placed;
    }

    public OrderTimeEntity setPlaced(ZonedDateTime placed) {
        this.placed = placed;
        return this;
    }

    public ZonedDateTime getRestaurantAccept() {
        return restaurantAccept;
    }

    public OrderTimeEntity setRestaurantAccept(ZonedDateTime restaurantAccept) {
        this.restaurantAccept = restaurantAccept;
        return this;
    }

    public ZonedDateTime getRestaurantStart() {
        return restaurantStart;
    }

    public OrderTimeEntity setRestaurantStart(ZonedDateTime restaurantStart) {
        this.restaurantStart = restaurantStart;
        return this;
    }

    public ZonedDateTime getRestaurantComplete() {
        return restaurantComplete;
    }

    public OrderTimeEntity setRestaurantComplete(ZonedDateTime restaurantComplete) {
        this.restaurantComplete = restaurantComplete;
        return this;
    }

    public ZonedDateTime getDriverAccept() {
        return driverAccept;
    }

    public OrderTimeEntity setDriverAccept(ZonedDateTime driverAccept) {
        this.driverAccept = driverAccept;
        return this;
    }

    public ZonedDateTime getDriverComplete() {
        return driverComplete;
    }

    public OrderTimeEntity setDriverComplete(ZonedDateTime driverComplete) {
        this.driverComplete = driverComplete;
        return this;
    }

    public ZonedDateTime getOrderComplete() {
        return orderComplete;
    }

    public OrderTimeEntity setOrderComplete(ZonedDateTime orderComplete) {
        this.orderComplete = orderComplete;
        return this;
    }

    public ZonedDateTime getDeliverySlot() {
        return deliverySlot;
    }

    public OrderTimeEntity setDeliverySlot(ZonedDateTime deliverySlot) {
        this.deliverySlot = deliverySlot;
        return this;
    }
}
