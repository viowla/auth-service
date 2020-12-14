package kz.iitu.authservice;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class UserService {

    private UserRepository userRepository;

    public Optional<User> findUserById(Long id) {
        System.out.println("Test");
        return userRepository.findById(id);
    }


    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        System.out.println(user.getUsername());
        return userRepository.save(user);
    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}