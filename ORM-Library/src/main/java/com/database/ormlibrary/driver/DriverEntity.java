package com.database.ormlibrary.driver;

import com.database.ormlibrary.user.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private UserEntity user;

    @OneToMany
    private List<DriverRatingEntity> ratings;
    private String car;

    @Column(columnDefinition = "boolean default false")
    private boolean checkedIn;

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public DriverEntity setCheckedIn(boolean active) {
        this.checkedIn = active;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public DriverEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public List<DriverRatingEntity> getRatings() {
        return ratings;
    }

    public DriverEntity setRatings(List<DriverRatingEntity> ratings) {
        this.ratings = ratings;
        return this;
    }

    public String getCar() {
        return car;
    }

    public DriverEntity setCar(String car) {
        this.car = car;
        return this;
    }
}
