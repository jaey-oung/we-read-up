package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.MemberDto;
import com.wru.wrubookstore.dto.UserDto;
import com.wru.wrubookstore.service.EmployeeService;
import com.wru.wrubookstore.service.MemberService;
import com.wru.wrubookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final MemberService memberService;
    private final EmployeeService employeeService;

    public RegisterController(UserService userService, MemberService memberService, EmployeeService employeeService) {
        this.userService = userService;
        this.memberService = memberService;
        this.employeeService = employeeService;
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
                throw new Exception("비회원 계정 생성 실패");

            rattr.addFlashAttribute("msg", "USER_SIGNUP_OK");
        } catch (Exception e) {
            model.addAttribute("userDto", userDto);
            model.addAttribute("msg", "USER_SIGNUP_ERR");
            return "login/register";
        }
        return "redirect:/";
    }

    @PostMapping("/member")
    public String registerMember(UserDto userDto, MemberDto memberDto, RedirectAttributes rattr, Model model) {
        try {
            memberService.insert(userDto, memberDto);
            rattr.addFlashAttribute("msg", "MEMBER_SIGNUP_OK");
        } catch (Exception e) {
            model.addAttribute("memberDto", memberDto);
            model.addAttribute("msg", "MEMBER_SIGNUP_ERR");
            return "login/register";
        }
        return "redirect:/";
    }

    @PostMapping("/check/email")
    @ResponseBody
    public String checkEmailDuplicate(@RequestBody Map<String, String> request) {
        String email = request.get("email");

        try {
            // 직원 테이블 중복 확인
            int result = employeeService.isEmailDuplicated(email.trim());
            if (result == 1)
                return "중복된 이메일입니다";

            // 비회원/회원 테이블 중복 확인
            result = userService.isEmailDuplicated(email.trim());
            return result == 1 ? "중복된 이메일입니다" : "사용 가능한 이메일입니다";
        } catch (Exception e) {
            return "중복확인 처리 중 오류가 발생했습니다";
        }
    }
}
