package com.database.ormlibrary.food;

import com.database.ormlibrary.HoursEmbeddable;
import com.database.ormlibrary.SearchEmbeddable;

import javax.persistence.*;
import java.util.List;

@Entity
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String iconId;
    private String backgroundId;
    private Integer averageTime; //minutes
    private Integer averageRating; //stars
    private Integer priceRating; //1-4
    private String address;
    private String geolocation;
    @Embedded
    private HoursEmbeddable hours;
    @Embedded
    private SearchEmbeddable search;
    //    @Embedded
//    private CoordinatesEmbeddable coordinates;
    @OneToMany
    private List<PromotionsEntity> promotions;
    @OneToMany
    private List<MenuItemEntity> menu;
    @OneToMany
    private List<RestaurantRatingEntity> ratings;

    @Override
    public String toString() {
        return "RestaurantEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconId=" + iconId +
                ", backgroundId=" + backgroundId +
                ", averageTime=" + averageTime +
                ", averageRating=" + averageRating +
                ", priceRating=" + priceRating +
                ", address='" + address + '\'' +
                ", geolocation='" + geolocation + '\'' +
                ", hours=" + hours +
                ", search=" + search +
                ", promotions=" + promotions +
                ", menu=" + menu +
                ", ratings=" + ratings +
                '}';
    }

    public Long getId() {
        return id;
    }

    public RestaurantEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getIconId() {
        return iconId;
    }

    public RestaurantEntity setIconId(String iconId) {
        this.iconId = iconId;
        return this;
    }

    public String getBackgroundId() {
        return backgroundId;
    }

    public RestaurantEntity setBackgroundId(String backgroundId) {
        this.backgroundId = backgroundId;
        return this;
    }

    public Integer getAverageTime() {
        return averageTime;
    }

    public RestaurantEntity setAverageTime(Integer averageTime) {
        this.averageTime = averageTime;
        return this;
    }

    public Integer getAverageRating() {
        return averageRating;
    }

    public RestaurantEntity setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public Integer getPriceRating() {
        return priceRating;
    }

    public RestaurantEntity setPriceRating(Integer priceRating) {
        this.priceRating = priceRating;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RestaurantEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public HoursEmbeddable getHours() {
        return hours;
    }

    public void setHours(HoursEmbeddable hours) {
        this.hours = hours;
    }

    public SearchEmbeddable getSearch() {
        return search;
    }

    public RestaurantEntity setSearch(SearchEmbeddable search) {
        this.search = search;
        return this;
    }

    public List<MenuItemEntity> getMenu() {
        return menu;
    }

    public RestaurantEntity setMenu(List<MenuItemEntity> menu) {
        this.menu = menu;
        return this;
    }

    public List<RestaurantRatingEntity> getRatings() {
        return ratings;
    }

    public RestaurantEntity setRatings(List<RestaurantRatingEntity> ratings) {
        this.ratings = ratings;
        return this;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public List<PromotionsEntity> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<PromotionsEntity> promotions) {
        this.promotions = promotions;
    }
}
