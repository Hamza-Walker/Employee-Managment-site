package com.walker.repository;


import com.walker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository  {
    User findUserByUsername(String username);

    Collection<User> getAllUsers();

    User addUser(User newUser);
}