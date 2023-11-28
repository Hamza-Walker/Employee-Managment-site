package com.walker.controler;

import com.walker.model.User;
import com.walker.service.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userServices;

    @GetMapping
    public ResponseEntity<Collection<User>> getUsers() {
        Collection<User> users = this.userServices.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Optional<User>> postUsers(@RequestBody User newUser) {
        Optional<User> user = this.userServices.createUser(newUser);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
