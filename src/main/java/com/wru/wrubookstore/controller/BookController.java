package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/bookList")
    public String bookList() {

        return "book/book-list";
    }

    @GetMapping("/bookDetail")
    public String bookDetail() {

        return "book/book-detail";
    }
}
