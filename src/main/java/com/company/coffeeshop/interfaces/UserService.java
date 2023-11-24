package com.company.coffeeshop.interfaces;

import com.company.coffeeshop.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(String username, User user);

    void deleteUser(String username);

    User getUserByUsername(String username);
}
