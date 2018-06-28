package com.goods.controller;

import com.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = "application/json")
    public void createUser(@RequestBody String username, String password){
        userService.createUser(username,password);
    }
}
