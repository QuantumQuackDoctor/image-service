package com.database.ormlibrary.food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String configurationName;

    public Long getId() {
        return id;
    }

    public ConfigurationEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public ConfigurationEntity setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
        return this;
    }

}
