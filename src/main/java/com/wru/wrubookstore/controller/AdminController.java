package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/bookList")
    public String bookList(BookDto bookDto ){
        return "admin/admin-book-list";
    }

}
