package com.database.ormlibrary.food;

import com.database.ormlibrary.user.UserEntity;

import javax.persistence.*;

@Entity
public class RestaurantRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private UserEntity user;
    private String imageId;
    private Integer stars;
    private String description;

    public Long getId() {
        return id;
    }

    public RestaurantRatingEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public RestaurantRatingEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getImageId() {
        return imageId;
    }

    public RestaurantRatingEntity setImageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    public Integer getStars() {
        return stars;
    }

    public RestaurantRatingEntity setStars(Integer stars) {
        this.stars = stars;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RestaurantRatingEntity setDescription(String description) {
        this.description = description;
        return this;
    }


}