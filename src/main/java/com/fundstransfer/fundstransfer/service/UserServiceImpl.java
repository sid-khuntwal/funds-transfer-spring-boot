package com.fundstransfer.fundstransfer.service;

import com.fundstransfer.fundstransfer.entity.User;
import com.fundstransfer.fundstransfer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving users", e);
        }
    }

    @Override
    public User getUserById(Integer userId) {
        try {
            return userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found: " + userId));
        } catch (Exception e) {
            throw new RuntimeException("Error while getting user by ID: " + userId, e);
        }
    }

    @Override
    public User updateUser(Integer userId, User updatedUser) {
        User existingUser = userRepository.findById(userId).get();

        if(Objects.nonNull(updatedUser.getName()) && !"".equalsIgnoreCase(updatedUser.getName())){
            existingUser.setName(updatedUser.getName());
        }

        if(Objects.nonNull(updatedUser.getEmail()) && !"".equalsIgnoreCase(updatedUser.getEmail())){
            existingUser.setEmail(updatedUser.getEmail());
        }

        if(Objects.nonNull(updatedUser.getAccBalance())){
            existingUser.setAccBalance(updatedUser.getAccBalance());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUserById(Integer userId) {
    userRepository.deleteById(userId);
    }

}
