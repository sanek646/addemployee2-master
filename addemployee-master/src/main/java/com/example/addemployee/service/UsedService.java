package com.example.addemployee.service;

import com.example.addemployee.models.User;
import com.example.addemployee.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsedService {
    private final UserRepository userRepository;

  //  private User user;


    public UsedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User addUser(String firstName, String lastName, int companyId, String role){

        User user = new User(firstName, lastName, companyId, role);

       return userRepository.save(user);
    }

}

