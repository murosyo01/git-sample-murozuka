package com.example.controller;

import com.example.domain.User;
import com.example.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

    @GetMapping("")
    public String index(){
        return "redirect:/exam04/redirect";
    }

    @GetMapping("/redirect")
    public String index2(UserForm userForm){
        return "exam04";
    }

    @PostMapping("/result")
    public String result(UserForm userForm, Model model){
        User user = new User();

        user.setName(userForm.getName());
        user.setAge(userForm.getAge());
        user.setComment(userForm.getComment());

        model.addAttribute("user", user);

        return "exam04-result";
    }
}
