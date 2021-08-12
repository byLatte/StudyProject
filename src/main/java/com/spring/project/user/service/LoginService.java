package com.spring.project.user.service;

import com.spring.project.user.domain.LoginHist;
import com.spring.project.user.domain.User;
import com.spring.project.user.repository.LoginHistRepository;
import com.spring.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByUserId(String userId){
        return userRepository.findByUserId(userId);
    }

}
