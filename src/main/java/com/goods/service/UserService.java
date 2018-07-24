package com.goods.service;

import com.goods.entities.Role;
import com.goods.entities.User;
import com.goods.repository.IRoleRepository;
import com.goods.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;

    public User getUserById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User getUserByUsername(String username){
        return userRepository.getUsersByUsername(username);
    }

    public User createUser(String username, String password){
        User user = new User(username,null,true);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        passwordEncoder.encode(password);
        user.setPassword(passwordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getRoleByRole("USER"));
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }
}
