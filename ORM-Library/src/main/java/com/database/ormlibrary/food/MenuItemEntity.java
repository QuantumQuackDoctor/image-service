package com.database.ormlibrary.food;

import javax.persistence.*;
import java.util.List;

@Entity
public class MenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String imageId;
    private String allergens; //allergen,allergen,allergen
    private Float price;
    private String description;
    @OneToMany
    private List<ConfigurationEntity> configurations;

    public Long getId() {
        return id;
    }

    public MenuItemEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MenuItemEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageId() {
        return imageId;
    }

    public MenuItemEntity setImageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    public String getAllergens() {
        return allergens;
    }

    public MenuItemEntity setAllergens(String allergens) {
        this.allergens = allergens;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public MenuItemEntity setPrice(Float price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<ConfigurationEntity> getConfigurations() {
        return configurations;
    }

    public MenuItemEntity setConfigurations(List<ConfigurationEntity> configurations) {
        this.configurations = configurations;
        return this;
    }
}
