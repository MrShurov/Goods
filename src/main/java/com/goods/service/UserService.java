package com.goods.service;

import com.goods.entities.Role;
import com.goods.entities.User;
import com.goods.repository.IRoleRepository;
import com.goods.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final
    IUserRepository userRepository;
    private final
    IRoleRepository roleRepository;

    @Autowired
    public UserService(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return userRepository.getUsersByUsername(currentPrincipalName);
    }

    public User createUser(Map<String, Object> object) {
        User user = new User((String) object.get("username"), null, true);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode((String) object.get("password")));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getRoleByRole("USER"));
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }

    public User updateInformation(Map<String, Object> object){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userRepository.getUsersByUsername(currentPrincipalName);
        user.setCompanyName((String) object.get("companyName"));
        user.setPostCode((String) object.get("postCode"));
        user.setPaymentAccount((String) object.get("paymentAccount"));
        user.setBankRequisites((String) object.get("bankRequisites"));
        user.setUnp((String) object.get("unp"));
        user.setTel((String) object.get("tel"));
        userRepository.save(user);
        return user;
    }
}
