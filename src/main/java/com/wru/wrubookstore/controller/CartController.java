package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.CartDto;
import com.wru.wrubookstore.dto.response.cart.CartListResponse;
import com.wru.wrubookstore.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        try {
            list = cartService.selectCartListByUserId(userId);
        } catch (Exception e) {
            list = Collections.emptyList();
        }

        model.addAttribute("list", list);

        return "myPage/cart-list";
    }

    // 특정 사용자의 장바구니에 도서 한 권 추가
    @PostMapping("/add/one")
    @ResponseBody
    public String addOne(@SessionAttribute(value = "userId", required = false) Integer userId,
                         @RequestBody CartDto cartDto) {
        // 로그인 하지 않았다면 로그인이 필요하다는 메시지 반환
        if (userId == null)
            return "LOGIN_REQUIRED";

        cartDto.setUserId(userId);
        cartDto.setQuantity(1);
        try {
            int result = cartService.addOne(cartDto);
            return result == 1 ? "장바구니에 추가되었습니다" : "장바구니에 추가하지 못했습니다";
        } catch (Exception e) {
            return "장바구니 처리 중 오류가 발생했습니다";
        }
    }

    // 특정 사용자의 장바구니에 도서 여러 권 추가
    @PostMapping("/add/multiple")
    @ResponseBody
    public String addMultiple(@SessionAttribute(value = "userId", required = false) Integer userId,
                              @RequestBody CartDto cartDto) {
        // 로그인 하지 않았다면 로그인이 필요하다는 메시지 반환
        if (userId == null)
            return "LOGIN_REQUIRED";

        cartDto.setUserId(userId);
        try {
            int result = cartService.addMultiple(cartDto);
            return result == 1 ? "장바구니에 추가되었습니다" : "장바구니에 추가하지 못했습니다";
        } catch (Exception e) {
            return "장바구니 처리 중 오류가 발생했습니다";
        }
    }

}

