package com.database.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String createJwt(AuthDetails details) {
        return Jwts.builder()
                .setSubject(String.valueOf(details.getUsername()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims getAllClaims(String token) throws ExpiredJwtException {
        Claims c = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return c;
    }

    public boolean isInvalid(String token) {
        try {
            return getAllClaims(token).getExpiration().before(new Date(System.currentTimeMillis()));
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public String getEmail(String token) throws ExpiredJwtException {
        String res = getAllClaims(token).getSubject();
        return res;
    }
}
