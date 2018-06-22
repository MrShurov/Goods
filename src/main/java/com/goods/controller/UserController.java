package com.goods.controller;

import com.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @GetMapping("/createUser")
    public void createUser(@RequestBody String username, String password){
        userService.createUser(username,password);
    }
}
