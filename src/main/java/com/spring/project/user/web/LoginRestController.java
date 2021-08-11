package com.spring.project.user.web;

import com.spring.project.user.domain.LoginHist;
import com.spring.project.user.domain.User;
import com.spring.project.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class LoginRestController {

    private final LoginService loginService;

    public LoginRestController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/signup")
    public String signUp(User user){
        loginService.save(user);
        return "view/user/login";
    }
}
