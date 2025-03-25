package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.CartDto;
import com.wru.wrubookstore.dto.response.cart.CartListResponse;
import com.wru.wrubookstore.service.BookService;
import com.wru.wrubookstore.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 특정 사용자의 전체 장바구니 목록 조회
    @GetMapping("/list")
    public String cartList(@SessionAttribute(value = "userId", required = false) Integer userId,
                           HttpServletRequest request, Model model) {
        // 로그인 하지 않았다면 로그인 화면으로 이동
        if (userId == null)
            return "redirect:/login/login?redirectUrl="+request.getRequestURL();

        List<CartListResponse> list;
        int cnt;

        try {
            list = cartService.selectCartListByUserId(userId);
            cnt = cartService.countAllByUserId(userId);
        } catch (Exception e) {
            list = Collections.emptyList();
            cnt = 0;
        }

        model.addAttribute("list", list);

        return "myPage/cart-list";
    }

    // 특정 사용자의 장바구니 추가
    @ResponseBody
    @PostMapping("/insert")
    public String insert(@RequestBody CartDto cartDto) throws Exception {
        return cartService.insert(cartDto);
    }

}

