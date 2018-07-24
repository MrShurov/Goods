package com.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/createUser")
    public String user() {
        return "/createUser";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}
