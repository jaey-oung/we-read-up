package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.CouponDto;
import com.wru.wrubookstore.service.CouponService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/myPage/couponList")
    public String couponList(@RequestParam(defaultValue = "1") int page, Model model) {
        try {
            // 임의의 회원 값 입력(수정 필요)
            List<CouponDto> couponDtoList = couponService.selectList(1);
            int couponCount = couponService.selectCount(1);
            PageHandler ph = new PageHandler(couponCount, page);

            model.addAttribute("couponList", couponDtoList);
            model.addAttribute("ph", ph);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "myPage/coupon-list";
    }
}
