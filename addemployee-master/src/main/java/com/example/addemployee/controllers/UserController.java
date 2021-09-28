package com.example.addemployee.controllers;

import com.example.addemployee.models.User;
import com.example.addemployee.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService usedService) {
        this.userService = usedService;
    }


    @PostMapping("/add")
    public String userAdd(@RequestParam(value = "firstname", required = false)String firstName,
                         @RequestParam(value = "lastname",required = false)String lastName,
                         @RequestParam(value = "companyId",required = false)int companyId,
                         @RequestParam(value = "role", required = false)String role,
                         Model model){
        String userAdd = userService.addUser(firstName, lastName, companyId, role).toString();
        model.addAttribute("userString", userAdd);
        return "/add-edit";
    }

    @GetMapping("/about")
    public String userList(Model model) {
        Iterable<User> users = userService.allUser();
        model.addAttribute("posts", users);
        return "/employee";
    }

    @GetMapping("/employee/{id}")
    public String userDetails(@PathVariable(value = "id") long id,
                              Model model) {
       // ArrayList res = userService.editDetails(id);
        model.addAttribute("post", userService.editDetails(id));
        return "/employee-details";
    }

    @GetMapping("/employee/{id}/edit")
    public String userEdit(@PathVariable(value = "id") long id,
                              Model model) {

        model.addAttribute("post", userService.editUser(id));
        return "/employee-edit";
    }

    @PostMapping("/employee/{id}/edit")
    public String userUpdate(@PathVariable(value = "id") long id,
                             @RequestParam(value = "firstname", required = false)String firstName,
                          @RequestParam(value = "lastname",required = false)String lastName,
                          @RequestParam(value = "companyId",required = false)int companyId,
                          @RequestParam(value = "role", required = false)String role,
                          Model model){

        String userUpdate = userService.updateUser(id,firstName, lastName, companyId, role).toString();
        model.addAttribute("userString", userUpdate);
        return "redirect:/about";
    }

    @PostMapping("/employee/{id}/remove")
    public String userDelete(@PathVariable(value = "id") long id, Model model){
        userService.deleteUser(id);
        return "redirect:/about";
    }

    @PostMapping("/adding a list")
    public String uploadCSVFile(@RequestParam(value = "file") MultipartFile file, Model model){
if (file.isEmpty()){
    model.addAttribute("mes","please");
    System.out.println("empty");

}else {
        userService.appLoadCsv(file);
}
        return "employee-add";
    }
}
