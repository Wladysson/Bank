package com.corebanking.iam.auth;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;
import java.util.Set;

@ApplicationScoped
public class JwtTokenGenerator {

    public String generate(String username, Set<String> roles) {
        return Jwt.issuer("core-banking-iam")
                .subject(username)
                .groups(roles)
                .expiresIn(Duration.ofHours(1))
                .sign();
    }
}