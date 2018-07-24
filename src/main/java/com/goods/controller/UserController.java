package com.goods.controller;

import com.goods.entities.User;
import com.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<User> createUser(@RequestParam Map<String, Object> object){
        String username = (String) object.get("username");
        String password = (String) object.get("password");
        User user = userService.createUser(username,password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
