package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @GetMapping("/myPage/editProfile")
    public String editProfileForm() {

        return "myPage/edit-profile";
    }

    @PostMapping("/myPage/editProfile")
    public String editProfile() {

        return "redirect:/myPage";
    }
}
