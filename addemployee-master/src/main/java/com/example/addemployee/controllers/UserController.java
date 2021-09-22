package com.example.addemployee.controllers;

import com.example.addemployee.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService usedService) {
        this.userService = usedService;
    }


    @PostMapping("/") // получение из формы "post" (из html)

   public String userAdd(@RequestParam(value = "firstname", required = false)String firstName, //  данные с полей формы
                         @RequestParam(value = "lastname",required = false)String lastName,
                         @RequestParam(value = "companyId",required = false)int companyId,
                         @RequestParam(value = "role", required = false)String role,
                         Model model){


        String userAdd = userService.addUser(firstName, lastName, companyId, role).toString();
        // создание строковой переменной из класса usedService метода addUser с приведением к строке toString из heap

        model.addAttribute("userString", userAdd); //помещение содержимого перменной user в html

        return "/edit";
    }



}
