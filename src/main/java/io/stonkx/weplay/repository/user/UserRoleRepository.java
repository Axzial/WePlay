package io.stonkx.weplay.repository.user;

import io.stonkx.weplay.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    boolean existsByName(String name);
}
