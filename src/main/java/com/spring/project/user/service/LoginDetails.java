package com.spring.project.user.service;

import com.spring.project.user.domain.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;


@Data
@Slf4j
public class LoginDetails extends org.springframework.security.core.userdetails.User {

    private final User user;

    public LoginDetails(User user){
        super(user.getUserId(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole()));
        this.user = user;
        log.info("LOGIN USER ROLE : " + user.getRole());
    }

}
