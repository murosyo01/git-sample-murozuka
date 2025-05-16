package com.example.controller;

import com.example.domain.User;
import com.example.form.UserForm;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

    @GetMapping("")
    public String index(UserForm userForm, Model model){
        return "exam04";
    }

    @PostMapping("/result")
    public String result(@Validated UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()){
            return index(userForm,model);
        }

        User user = new User();
        BeanUtils.copyProperties(userForm, user);

        redirectAttributes.addFlashAttribute("user", user);

        return "redirect:/exam04/showResult";
    }

    @GetMapping("/showResult")
    public String showResult(){
        return "exam04-result";
    }
}
