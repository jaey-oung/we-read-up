package com.wru.wrubookstore.controller;


import com.wru.wrubookstore.dto.UserDto;
import com.wru.wrubookstore.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(String email, String password, String redirectUrl, boolean rememberId, RedirectAttributes rattr,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        boolean isFieldNullOrEmpty = email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty();
        UserDto userDto = userService.login(email, password);

        System.out.println("email = " + email);
        System.out.println("password = " + password);
        System.out.println("isFieldNullOrEmpty = " + isFieldNullOrEmpty);
        System.out.println("userDto = " + userDto);

        if(isFieldNullOrEmpty || userDto == null) {
            rattr.addFlashAttribute("email", email);
            rattr.addFlashAttribute("password", password);
            rattr.addFlashAttribute("msg", isFieldNullOrEmpty ? "EMPTY_FIELD" : "LOGIN_ERR");
            return "redirect:/login/login?redirectUrl="+redirectUrl;
        }

        // 세션에 연결
        HttpSession session = request.getSession();

        // userId 와 isMember 정보 저장
        session.setAttribute("userId", userDto.getUserId());
        session.setAttribute("isMember", userDto.getIsMember());

        // 쿠키 저장
        Cookie cookie = new Cookie("email", email);

        // ID 기억하기 체크 했을 경우 쿠키 30일 유지
        // ID 기억하기 체크 안했을 경우 쿠키 삭제
        cookie.setMaxAge(!rememberId ? 0 : 60 * 60 * 24 * 30);
        response.addCookie(cookie);

        redirectUrl = (redirectUrl == null || redirectUrl.isEmpty()) ? "/" : redirectUrl;

        System.out.println("userDto = " + userDto);
        return "redirect:"+redirectUrl;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
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
