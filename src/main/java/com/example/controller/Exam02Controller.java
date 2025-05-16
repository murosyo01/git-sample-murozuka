package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
    @GetMapping("")
    public String index(){
        return "exam02";
    }

    @PostMapping("/result")
    public String result(String num1, String num2, Model model){
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", Integer.parseInt(num1) + Integer.parseInt(num2));
        return "exam02-result";
    }
}
