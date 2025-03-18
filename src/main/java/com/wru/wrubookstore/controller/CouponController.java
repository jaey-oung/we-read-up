package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.CouponDto;
import com.wru.wrubookstore.service.CouponService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/myPage/couponList")
    public String couponList(Model model) {
        try {
            List<CouponDto> couponDtoList = couponService.selectList(1);

            model.addAttribute("couponList", couponDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "myPage/coupon-list";
    }
}
