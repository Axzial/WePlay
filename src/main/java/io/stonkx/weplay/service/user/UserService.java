package io.stonkx.weplay.service.user;

import io.stonkx.weplay.model.user.User;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Page<User> getUsersPage(int page, int size);
    
    Optional<User> findById(UUID id);

    User getById(UUID id);

    User createUser(User user);

    User saveUser(User user);

    void deleteUser(UUID id);
}
