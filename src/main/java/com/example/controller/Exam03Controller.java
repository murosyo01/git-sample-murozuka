package com.example.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(){
        return "exam03.html";
    }

    @PostMapping("/result")
    public String result(String product1, String product2, String product3){
        application.setAttribute("sum", Integer.parseInt(product1) + Integer.parseInt(product2) + Integer.parseInt(product3));
        return "exam03-result";
    }

    @GetMapping("/result")
    public String showResult(){
        return "exam03-result";
    }
}
