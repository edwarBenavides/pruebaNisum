package com.pruebaNisum.pruebaNisum.configuration;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JwtConfiguration {
    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtParser jwtParser() {
        return Jwts.parser().setSigningKey(secret);
    }
}
