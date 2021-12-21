package com.felipe.blog.controller;

import com.felipe.blog.domain.model.User;
import com.felipe.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{user_id}")
    public User updateUser(@PathVariable Long user_id, @RequestBody User user){
        User tmpUser = userService.getUser(user_id);
        if(tmpUser != null){
            tmpUser.setName(user.getName());
            tmpUser.setUsername(user.getUsername());
            tmpUser.setEmail(user.getEmail());
            tmpUser.setPassword(user.getPassword());

            userService.saveUser(tmpUser);
            return tmpUser;
        }
        return null;
    }

}
