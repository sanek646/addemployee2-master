package com.example.addemployee.controllers;

import com.example.addemployee.models.User;
import com.example.addemployee.service.UserService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


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
        Iterable<User> users = userService.listAllUser();
        model.addAttribute("posts", users);
        return "/employee";
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

    @PostMapping("/uploadCSVFile")
    public String uploadCSVFile(@RequestParam(value = "file") MultipartFile file, Model model){
        if (file.isEmpty()){
            model.addAttribute("mes","please");
            System.out.println("empty");

        }else {

            userService.uploadCsv(file);
        }
        return "add-edit";
    }
    @GetMapping("/export-users")
    public void exportCSV(HttpServletResponse response) throws Exception {

        //set file name and content type
        String filename = "users.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<User> writer = new StatefulBeanToCsvBuilder<User>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        List<User> users = (List<User>)userService.listAllUser();
        //write all users to csv file
        writer.write(users);

    }
}
