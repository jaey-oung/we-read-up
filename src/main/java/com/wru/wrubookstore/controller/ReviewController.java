package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

    @GetMapping("/reviewList")
    public String reviewList() {

        return "board/review-list";
    }

    @GetMapping("/reviewDetail")
    public String reviewDetail() {

        return "board/review-detail";
    }
}
