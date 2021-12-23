package com.felipe.blog.controller;

import com.felipe.blog.domain.model.User;
import com.felipe.blog.dto.Userdto;
import com.felipe.blog.exceptions.UserControllerException.UserException;
import com.felipe.blog.service.UserService;
import com.felipe.blog.util.Hash;
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
    public List<Userdto> getUsers() {
        try {
            return userService.getUsers();
        }catch (Exception e){
            throw new UserException("No records!");
        }

    }

    @PostMapping
    public List<Userdto> addUser(@RequestBody User user){
        try{
            Hash hash = new Hash(user.getPassword());
            user.setPassword(hash.hashPassword());
            return userService.saveUser(user);
        }catch (Exception e){
            throw new UserException("Username or email already taken!");
        }
    }

    @PutMapping("/{user_id}")
    public List<Userdto> updateUser(@PathVariable Long user_id, @RequestBody User updatedUser){
        try{
            User user = userService.getUser(user_id);
            if(user != null){
                Hash hash = new Hash(updatedUser.getPassword());
                user.setName(updatedUser.getName());
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(hash.hashPassword());
                return userService.saveUser(user);
            }
            return null;
        }catch (Exception e){
            throw new UserException("Cannot update the selected user!");
        }

    }

}
