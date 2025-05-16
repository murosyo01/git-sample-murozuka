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
    public String result(){
        application.setAttribute("sum", Integer.parseInt((String) application.getAttribute("product1")) + Integer.parseInt((String) application.getAttribute("product2")) + Integer.parseInt((String) application.getAttribute("product3")));
        return "exam03-result";
    }
}
