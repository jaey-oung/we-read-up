package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.UserDto;
import com.wru.wrubookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/form")
    public String registerForm() {

        return "login/register";
    }

    @PostMapping("/user")
    public String registerUser(UserDto userDto, RedirectAttributes rattr, Model model) {
        try {
            int rowCnt = userService.insert(userDto);

            if(rowCnt != 1)
                throw new Exception("비회원 계정이 생성 실패.");

            rattr.addFlashAttribute("msg", "USER_SIGNUP_OK");
        } catch (Exception e) {
            model.addAttribute("userDto", userDto);
            model.addAttribute("msg", "USER_SIGNUP_ERR");
            return "login/register";
        }
        return "redirect:/";
    }
}
