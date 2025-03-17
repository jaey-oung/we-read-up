package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {

    @GetMapping("/noticeList")
    public String noticeList() {

        return "board/notice-list";
    }

    @GetMapping("/noticeDetail")
    public String noticeDetail() {

        return "board/notice-detail";
    }
}
