package com.goods.service;

import com.goods.entities.Users;
import com.goods.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public Users getUserById(Integer id){
        Optional<Users> user = userRepository.findById(id);
        return user.get();
    }
}
