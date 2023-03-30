package com.pruebaNisum.pruebaNisum.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtilConfiguration {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateJwtToken(String email, boolean isactive) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration * 60 * 1000);

        return Jwts.builder()
                .setSubject(email)
                .claim("isactive", isactive)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
