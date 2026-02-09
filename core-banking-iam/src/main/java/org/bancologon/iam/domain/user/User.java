package org.bancologon.iam.domain.user;

import java.util.Set;

public class User {

    private final Long id;
    private final String username;
    private final String passwordHash;
    private final boolean active;
    private final Set<Role> roles;

    public User(Long id,
                String username,
                String passwordHash,
                boolean active,
                Set<Role> roles) {

        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.active = active;
        this.roles = roles;
    }

    // ===== regras do domínio =====

    public boolean canAuthenticate() {
        return active;
    }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }

    // ===== getters =====

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
