package br.com.fiap.apinextgen.controller;

import br.com.fiap.apinextgen.model.User;
import br.com.fiap.apinextgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
