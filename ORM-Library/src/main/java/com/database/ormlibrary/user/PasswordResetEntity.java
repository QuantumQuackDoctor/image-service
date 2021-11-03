package com.database.ormlibrary.user;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
public class PasswordResetEntity {

    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserEntity user;
    @Column(unique = true)
    private UUID token;
    @Column
    private Instant tokenExpiration;

    public UserEntity getUser() {
        return user;
    }

    public PasswordResetEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public UUID getToken() {
        return token;
    }

    public PasswordResetEntity setToken(UUID token) {
        this.token = token;
        return this;
    }

    public Instant getTokenExpiration() {
        return tokenExpiration;
    }

    public PasswordResetEntity setTokenExpiration(Instant tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
        return this;
    }
}
