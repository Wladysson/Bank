package com.corebanking.iam.auth;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;

@ApplicationScoped
public class AuthService {

    @Inject
    JwtTokenGenerator tokenGenerator;

    public String authenticate(String username, String password) {

        if (!"admin".equals(username) || !"admin".equals(password)) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return tokenGenerator.generate(
                username,
                Set.of("ADMIN", "SETTLEMENT")
        );
    }
}
