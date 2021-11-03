package com.database.ormlibrary.driver;

import com.database.ormlibrary.user.UserEntity;

import javax.persistence.*;

@Entity
public class DriverRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private UserEntity user;
    private Integer stars;
    private String description;
}
