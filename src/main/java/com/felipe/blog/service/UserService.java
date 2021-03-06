package com.felipe.blog.service;

import com.felipe.blog.domain.model.User;
import com.felipe.blog.dto.Userdto;
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

    public List<Userdto> getUsers(){
        List<User> user = userRepository.findAll();
        return Userdto.convert(user);
    }

    public User getUser(Long user_id){
        if(userRepository.findById(user_id).isPresent()){
            return userRepository.findById(user_id).get();
        }
        return null;
    }

    public List<Userdto> saveUser(User user){
        return Userdto.convert(List.of(userRepository.save(user)));
    }
}
