package com.learning.springboot.controller;

import com.learning.springboot.entity.User;
import com.learning.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // http://localhost:8080/api/users
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user){
        int id = user.getId();
        String name = user.getName();

        return userService.updateUserById(id, name);

    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUserById(userId);
    }



}
