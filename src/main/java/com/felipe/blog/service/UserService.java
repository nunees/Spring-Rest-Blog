package com.felipe.blog.service;

import com.felipe.blog.domain.model.User;
import com.felipe.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){ return userRepository.findAll();}

    public User getUser(Long user_id){
        if(userRepository.findById(user_id).isPresent())
            return userRepository.findById(user_id).get();
        return null;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
