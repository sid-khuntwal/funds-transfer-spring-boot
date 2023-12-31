package com.fundstransfer.fundstransfer.service;

import com.fundstransfer.fundstransfer.entity.User;

import java.util.*;


public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUser();

    public User getUserById(Integer userId);

    public User updateUser(Integer userId, User updatedUser);

    public void deleteUserById(Integer userId);
}
