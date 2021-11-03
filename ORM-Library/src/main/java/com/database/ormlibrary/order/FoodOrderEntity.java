package com.database.ormlibrary.order;

import com.database.ormlibrary.food.MenuItemEntity;
import com.database.ormlibrary.food.RestaurantEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class FoodOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderConfigurationEntity> configurations;

    @ManyToOne
    private RestaurantEntity restaurant;

    @ManyToOne
    private MenuItemEntity menuItem;

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public FoodOrderEntity setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public MenuItemEntity getMenuItem() {
        return menuItem;
    }

    public FoodOrderEntity setMenuItem(MenuItemEntity menuItem) {
        this.menuItem = menuItem;
        return this;
    }

    public Long getId() {
        return id;
    }

    public FoodOrderEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public List<OrderConfigurationEntity> getConfigurations() {
        return configurations;
    }

    public FoodOrderEntity setConfigurations(List<OrderConfigurationEntity> configurations) {
        this.configurations = configurations;
        return this;
    }

}
