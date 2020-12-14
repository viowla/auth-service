package kz.iitu.authservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("/registration")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
