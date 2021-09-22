package com.example.addemployee.service;

import com.example.addemployee.models.User;
import com.example.addemployee.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository; // создание обьекта интерфейса UserRepository

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } // конструктор создание обьекта интерфейса UserRepository

    @Transactional //аннотация для работы с БД

    public User addUser(String firstName, String lastName, int companyId, String role){  // получаем из контроллера запрос от html ,создаем метод с аргументами

        User user = new User(firstName, lastName, companyId, role); // создаем обьект класса Юзвера с полями

       return userRepository.save(user);// соханяем в базу и толкаем класс  в (heap)
    }

}

