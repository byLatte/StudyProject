package com.spring.project.user.service;

import com.spring.project.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void passwordEncode(){

        String pwd = "1111";

        String encodePwd = passwordEncoder.encode(pwd);

        assertAll(
                () -> assertNotEquals(pwd,encodePwd),
                () -> assertTrue(passwordEncoder.matches(pwd,encodePwd))
        );

    }
}