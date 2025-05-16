package com.example.controller;

import com.example.domain.User;
import com.example.form.UserForm;
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
    public String index(){
        return "redirect:/exam04/redirect";
    }

    @GetMapping("/redirect")
    public String index2(UserForm userForm, Model model){
        return "exam04";
    }

    @PostMapping("/result")
    public String result(@Validated UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()){
            return index2(userForm,model);
        }

        User user = new User();

        user.setName(userForm.getName());
        user.setAge(userForm.getAge());
        user.setComment(userForm.getComment());

        redirectAttributes.addFlashAttribute("user", user);

        return "exam04-result";
    }
}
