package com.database.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthRepo authRepo;

    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, AuthRepo authRepo) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authRepo = authRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = header.replace("Bearer ", "");
        AuthDetails authDetails;
        try {
            authDetails = authRepo.findByEmail(jwtTokenUtil.getEmail(token)).map(it ->
                    new AuthDetails(it.getId(),
                            it.getEmail(),
                            it.getPassword(),
                            Collections.singleton(new SimpleGrantedAuthority(it.getUserRole().getRole())))
            ).orElse(null);
        } catch (ExpiredJwtException ignored) { //don't really need to read a message here
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is expired");
            return;
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                authDetails, null, authDetails == null ? Collections.emptyList() : authDetails.getAuthorities()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
