package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/myPage/orderList")
    public String orderList() {

        return "myPage/order-list";
    }
}
