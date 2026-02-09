package com.corebanking.iam.domain;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    public UUID id;

    @Column(unique = true, nullable = false)
    public String username;

    @Column(name = "password_hash", nullable = false)
    public String passwordHash;

    public boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public Set<RoleEntity> roles;
}