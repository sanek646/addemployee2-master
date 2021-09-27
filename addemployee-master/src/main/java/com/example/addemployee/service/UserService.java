package com.example.addemployee.service;

import com.example.addemployee.models.User;
import com.example.addemployee.repo.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserService {


    private final UserRepository userRepository;
         public UserService(UserRepository userRepository) { this.userRepository = userRepository;
    }

    @Transactional
    public User addUser(String firstName, String lastName, int companyId, String role){
        User user = new User(firstName, lastName, companyId, role);
        return userRepository.save(user);
    }

    @Transactional
    public Iterable<User> allUser(){
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    public User editDetails(long id){

        User res  = userRepository.findById(id).orElseThrow();
    return res;
    }

    @Transactional
    public User editUser(long id){

        User res  = userRepository.findById(id).orElseThrow();
        return res;
    }

    @Transactional
    public User updateUser(long id,String firstName, String lastName, int companyId, String role){
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCompanyId(companyId);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser( long id){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}

