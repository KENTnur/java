package com.education.projectteam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyEduController {

    @GetMapping("/MyEducation")
    public String myeduMain(Model model){
        return "myedu-main";

    }
}
