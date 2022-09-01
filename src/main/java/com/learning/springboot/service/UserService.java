package com.learning.springboot.service;

import com.learning.springboot.entity.User;
import com.learning.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User save(User user){
        User newUser = userRepo.save(user);
        return newUser;
    }

    public List<User> getAllUser()
    {
        return userRepo.findAll();
    }

    public User getUserById(int id){
        return userRepo.getUser(id);
    }
    public void deleteUserById(int id){
        userRepo.deleteUserById(id);
    }

    public User updateUserById(int id, String name){
        return userRepo.updateUser(id, name);
    }
}
