package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CouponController {

    @GetMapping("/myPage/couponList")
    public String couponList() {

        return "myPage/coupon-list";
    }
}
