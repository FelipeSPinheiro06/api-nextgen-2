package br.com.fiap.apinextgen.controller;

import br.com.fiap.apinextgen.dto.UserRequest;
import br.com.fiap.apinextgen.dto.UserResponse;
import br.com.fiap.apinextgen.model.User;
import br.com.fiap.apinextgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService
                    .findAll()
                    .stream()
                    .map(UserResponse::fromModel)
                    .toList();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        User user = userService.create(userRequest.toModel());

        var uri = uriBuilder
                        .path("/users/{id}")
                        .buildAndExpand(user.getId())
                        .toUri();

        return ResponseEntity
                    .created(uri)
                    .body(UserResponse.fromModel(user));
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
