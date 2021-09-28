package com.example.addemployee.controllers;

import com.example.addemployee.models.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class UploadController {

    /*@GetMapping("/")
    public String index(){
        return "index";
    }*/

    @PostMapping("/adding a list")

    public String uploadCSVFile(@RequestParam(value = "file")MultipartFile file, Model model) {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {


            CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<User> users = csvToBean.parse();

            return "/";
        }
    }

}
