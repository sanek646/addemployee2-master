package com.example.addemployee.service;

import com.example.addemployee.models.User;
import com.example.addemployee.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
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
    public ArrayList editDetails(long id){
     /*if (!userRepository.existsById(id)) {
        return "redirect:/employee";
    }*/
    Optional<User> post = userRepository.findById(id);
    ArrayList<User> res = new ArrayList<>();
        post.ifPresent(res::add);
    return res;
    }

    @Transactional
    public ArrayList editUser(long id){
     /*if (!userRepository.existsById(id)) {
        return "redirect:/employee";
    }*/
        Optional<User> post = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        post.ifPresent(res::add);
        return res;
    }

    @Transactional
    public User updateUser(String firstName, String lastName, int companyId, String role, long id){
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

