package com.spring.project.user.service;

import lombok.Data;
import com.spring.project.user.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;


@Data
public class LoginDetails extends org.springframework.security.core.userdetails.User {

    private final User user;

    public LoginDetails(User user){
        super(user.getUserId(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }

}
