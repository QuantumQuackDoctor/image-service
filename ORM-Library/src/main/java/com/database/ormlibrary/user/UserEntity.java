package com.database.ormlibrary.user;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private UUID activationToken;
    private Instant activationTokenExpiration;
    private Boolean activated;
    private LocalDate birthDate;
    private Boolean isVeteran;
    @ManyToOne
    private UserRoleEntity userRole;
    private Integer points;
    @Embedded
    private SettingsEntity settings;


    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public Instant getActivationTokenExpiration() {
        return activationTokenExpiration;
    }

    public UserEntity setActivationTokenExpiration(Instant activationTokenExpiration) {
        this.activationTokenExpiration = activationTokenExpiration;
        return this;
    }

    public UUID getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(UUID activationToken) {
        this.activationToken = activationToken;
    }

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getActivated() {
        return activated;
    }

    public UserEntity setActivated(Boolean activated) {
        this.activated = activated;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserEntity setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Boolean getVeteran() {
        return isVeteran;
    }

    public UserEntity setVeteran(Boolean veteran) {
        isVeteran = veteran;
        return this;
    }

    public UserRoleEntity getUserRole() {
        return userRole;
    }

    public UserEntity setUserRole(UserRoleEntity userRole) {
        this.userRole = userRole;
        return this;
    }

    public Integer getPoints() {
        return points;
    }

    public UserEntity setPoints(Integer points) {
        this.points = points;
        return this;
    }

    public SettingsEntity getSettings() {
        return settings;
    }

    public UserEntity setSettings(SettingsEntity settings) {
        this.settings = settings;
        return this;
    }
}
