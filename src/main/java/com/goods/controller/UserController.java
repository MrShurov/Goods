package com.goods.controller;

import com.goods.entities.User;
import com.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<User> createUser(@RequestParam Map<String, Object> object) {
        return new ResponseEntity<>(userService.createUser(object), HttpStatus.OK);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<User> getUser(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addInformation", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<User> addInformation(@RequestParam Map<String, Object> object){
        return new ResponseEntity<>(userService.updateInformation(object), HttpStatus.OK);
    }
}
