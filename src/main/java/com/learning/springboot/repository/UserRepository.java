package com.learning.springboot.repository;

import com.learning.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {

    List<User> users  = new ArrayList<>();
    int key = 0;

    public User save(User user){

        if(user.getId() == 0){
            user.setId(++key);
        }
        String name = user.getName();
        users.add(user);
        return user;
    }

    public List<User> findAll()
    {
        return users;
    }

    public User getUser(int id){

       // User user = users.stream().filter(u -> u.getId() == id).findAny().get();

        User user = null;
        for(User u : users){
            if(u.getId() == id){
                user = u;
                break;
            }
        }
        return  user;
    }

    public void deleteUserById(int id){
        for(User u: users){
            if(u.getId() == id){
                users.remove(u);
            }
        }
    }

    public User updateUser(int id, String name){
        User u = null;
        for(User user: users){
            if(user.getId() == id)
            {
                user.setName(name);
                u = user;
            }
        }
        return u;
    }

}
