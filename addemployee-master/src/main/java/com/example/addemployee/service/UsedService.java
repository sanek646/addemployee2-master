package com.example.addemployee.service;

import com.example.addemployee.models.User;
import com.example.addemployee.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsedService {
    private final UserRepository userRepository;
    private User user;


    public UsedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void addUser(User user){
        this.user = user;
        userRepository.save(user);
    }

}

