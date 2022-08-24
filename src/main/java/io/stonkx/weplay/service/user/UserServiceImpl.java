package io.stonkx.weplay.service.user;

import io.stonkx.weplay.model.user.Role;
import io.stonkx.weplay.model.user.User;
import io.stonkx.weplay.model.user.UserRole;
import io.stonkx.weplay.repository.user.UserRepository;
import io.stonkx.weplay.repository.user.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @PostConstruct
    public void initRoles() {
        Arrays.stream(Role.values())
                .filter(x -> !userRoleRepository.existsByName(x.name()))
                .forEach(z -> userRoleRepository.save(UserRole.builder().name(z.name()).build()));
    }

    @Override
    public Page<User> getUsersPage(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User getById(UUID id) {
        return findById(id).orElseThrow();
    }

    @Override
    public User createUser(User user) {
        user.setCoins(BigDecimal.ZERO);
        return userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

}
