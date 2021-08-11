package com.spring.project.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/index")
    public String login(){
        return "view/user/index";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "view/user/sign_up";
    }
}
