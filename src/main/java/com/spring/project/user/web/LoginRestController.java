package com.spring.project.user.web;

import com.spring.project.user.domain.User;
import com.spring.project.user.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    private final LoginService loginService;

    public LoginRestController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(){
        return "view/index";
    }

    @PostMapping("/signup")
    public String signUp(User user){
        loginService.save(user);
        return "view/user/login";
    }
}
