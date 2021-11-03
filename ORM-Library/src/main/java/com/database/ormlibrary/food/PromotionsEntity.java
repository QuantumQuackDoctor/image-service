package com.database.ormlibrary.food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PromotionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String condition;
    private String discount; //type:amount ex. %:2.4

    public Long getId() {
        return id;
    }

    public PromotionsEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PromotionsEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public PromotionsEntity setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public String getDiscount() {
        return discount;
    }

    public PromotionsEntity setDiscount(String discount) {
        this.discount = discount;
        return this;
    }

}
