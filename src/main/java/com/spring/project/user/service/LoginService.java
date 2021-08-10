package com.spring.project.user.service;

import com.spring.project.user.domain.User;
import com.spring.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

}
