package com.database.security;

import com.database.ormlibrary.user.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetails implements UserDetailsService {
    private final AuthRepo authRepo;

    public CustomUserDetails(AuthRepo authRepo) {
        this.authRepo = authRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> entity = authRepo.findByEmail(username); //username is email in this schema
        if (entity.isPresent() && entity.get().getActivated()) {
            UserEntity user = entity.get();
            //create user details
            return new AuthDetails(
                    user.getId(),
                    user.getEmail(),
                    user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().getRole())));

        } else {
            throw new UsernameNotFoundException("invalid credentials");
        }
    }
}
