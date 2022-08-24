package io.stonkx.weplay.controller.user;

import io.stonkx.weplay.model.user.User;
import io.stonkx.weplay.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "12", required = false) int size) {
        return userService.getUsersPage(page, size);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getById(id);
    }


}
