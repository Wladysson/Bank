package org.bancologon.iam.infrastructure.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.bancologon.iam.domain.user.Role;
import org.bancologon.iam.domain.user.User;
import org.bancologon.iam.domain.user.UserRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<User> findByUsername(String username) {

        UserJpaEntity entity = entityManager
                .createQuery(
                        "SELECT u FROM UserJpaEntity u WHERE u.username = :username",
                        UserJpaEntity.class
                )
                .setParameter("username", username)
                .getResultStream()
                .findFirst()
                .orElse(null);

        if (entity == null) {
            return Optional.empty();
        }

        return Optional.of(toDomain(entity));
    }

    // ===== mapper =====
    private User toDomain(UserJpaEntity entity) {

        Set<Role> roles = entity.getRoles()
                .stream()
                .map(Role::valueOf)
                .collect(Collectors.toSet());

        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getPasswordHash(),
                entity.isActive(),
                roles
        );
    }
}
