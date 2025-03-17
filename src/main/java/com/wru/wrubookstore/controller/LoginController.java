package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {

        return "login/login";
    }

    @PostMapping("/login")
    public String login() {

        return "redirect:/";
    }

    @GetMapping("/findId")
    public String findIdForm() {

        return "login/find-id";
    }

    @GetMapping("/findPw")
    public String findPwForm() {

        return "login/find-pw";
    }
}
