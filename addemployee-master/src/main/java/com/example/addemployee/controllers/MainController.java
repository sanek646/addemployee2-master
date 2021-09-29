package com.example.addemployee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "First page");
        return "firstPage";
    }
    @GetMapping("/all")
    public String add( Model model) {
        model.addAttribute("title", "First page");
        return "employeeNewAdd";
    }
}