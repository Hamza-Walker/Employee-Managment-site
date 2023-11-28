package com.walker.repository;

import com.walker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;

    @Autowired
    public UserRepositoryImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public User findUserByUsername(String username) {
        return users.stream()
                .filter(user -> Objects.equals(user.getUsername(), username))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.users;
    }

    @Override
    public User addUser(User newUser) {
        this.users.add(newUser);
        return newUser;
    }
}
