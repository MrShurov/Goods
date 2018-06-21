package com.goods.service;

import com.goods.entities.User;
import com.goods.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public User getUserById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User getUserByUsername(String username){
        return userRepository.getUsersByUsername(username);
    }
}
