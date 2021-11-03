package com.database.security;

import com.database.ormlibrary.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepo extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
