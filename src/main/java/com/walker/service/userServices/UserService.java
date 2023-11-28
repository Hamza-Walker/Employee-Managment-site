package com.walker.service.userServices;


import com.walker.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Collection<User> getAllUsers();

    Optional<User> createUser(User newUser);

    boolean validateLogin(User loginData);
}
