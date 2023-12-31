package com.fundstransfer.fundstransfer.controller;
import java.util.*;
import com.fundstransfer.fundstransfer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fundstransfer.fundstransfer.service.UserService;
import com.fundstransfer.fundstransfer.service.UserServiceImpl;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(
            @PathVariable Integer userId,
            @RequestBody User updatedUser
    ) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUserById(@PathVariable("userId") Integer userId){
        userService.deleteUserById(userId);
        return "Deleted";
    }
}
