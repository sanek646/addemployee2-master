package com.example.addemployee.service;

import com.example.addemployee.models.Users;
import com.example.addemployee.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsedService {
    private final UserRepository userRepository;
    private Users users;


    public UsedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void addUser(Users users){
        this.users = users;
        userRepository.save(users);
    }

}

