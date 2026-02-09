package com.corebanking.iam.security;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;
import java.util.Set;

@ApplicationScoped
public class JwtService {

    public String generateToken(String username, Set<String> roles) {
        return Jwt.issuer("core-banking")
                .subject(username)
                .groups(roles) // roles do usuário
                .expiresIn(Duration.ofHours(1))
                .sign();
    }
}
