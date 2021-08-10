package com.spring.project.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "view/user/login";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "view/user/sign_up";
    }
}
