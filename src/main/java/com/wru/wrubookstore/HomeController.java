package com.wru.wrubookstore;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String home(HttpSession session) {
        // 임시 로그인을 위한 세션 저장
        session.setAttribute("userId", "3");
        session.setMaxInactiveInterval(3000);

        return "home";
    }
}
