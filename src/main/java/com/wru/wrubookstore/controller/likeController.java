package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class likeController {

    @GetMapping("/myPage/likeList")
    public String likeList() {

        return "myPage/like-list";
    }
}
