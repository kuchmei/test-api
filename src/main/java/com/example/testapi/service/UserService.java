package com.example.testapi.service;

import com.example.testapi.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    void deleteUserById(Long id);
}
