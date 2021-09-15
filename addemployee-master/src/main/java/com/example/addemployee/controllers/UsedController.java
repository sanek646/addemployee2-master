package com.example.addemployee.controllers;

import com.example.addemployee.models.User;
import com.example.addemployee.service.UsedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsedController {

    private final UsedService usedService;

    public UsedController(UsedService usedService) {
        this.usedService = usedService;
    }


    @PostMapping("/")

   public String userAdd(@RequestParam(value = "firstname", required = false)String firstName,
                         @RequestParam(value = "lastname",required = false)String lastName,
                         @RequestParam(value = "companyId",required = false)int companyId,
                         @RequestParam(value = "role", required = false)String role,
                         Model model){


        String user = usedService.addUser(firstName, lastName, companyId, role).toString();
        model.addAttribute("userString", user);

        return "/about";
    }

}
