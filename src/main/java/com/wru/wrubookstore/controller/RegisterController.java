package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String registerForm() {

        return "login/register";
    }

    @PostMapping("/register")
    public String register() {

        return "redirect:/login";
    }

}
