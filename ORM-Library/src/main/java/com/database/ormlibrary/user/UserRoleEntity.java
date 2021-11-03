package com.database.ormlibrary.user;

import javax.persistence.*;

@Entity
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String role;

    public Long getId() {
        return id;
    }

    public UserRoleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRoleEntity setRole(String role) {
        this.role = role;
        return this;
    }
}
