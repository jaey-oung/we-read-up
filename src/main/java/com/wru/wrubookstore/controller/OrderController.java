package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.request.order.OrderDetailRequest;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;
import com.wru.wrubookstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/myPage/orderList")
    public String orderList(@SessionAttribute Integer userId, Model model, @ModelAttribute OrderSearchCondition osc) {
        try {
            // 주문 상태와 날짜 조건에 따른 총 게시물 개수
            int orderCnt = orderService.selectOrderCnt(userId, osc);
            // PageHandler 생성
            PageHandler ph = new PageHandler(orderCnt, osc.getPage(), 4);
            // 검색 조건에 offset 설정
            osc.setOffset(osc.getPageSize() * (osc.getPage() - 1));
            // 주문 상태와 날짜 조건 페이징에 따른 게시물 리스트
            List<OrderHistoryRequest> orderHistoryRequest = orderService.selectOrderHistory(userId, osc);

            model.addAttribute("orderList", orderHistoryRequest);
            model.addAttribute("osc", osc);
            model.addAttribute("ph", ph);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "myPage/order-list";
    }

    @GetMapping("/myPage/orderDetail/{orderId}")
    public String orderDetail(@PathVariable Integer orderId, Model model) {
        try {
            // 주문 상세 정보를 위한 Dto 생성
            OrderDetailRequest orderDetailRequest = orderService.selectOrderDetail(orderId);

            model.addAttribute("orderDetail", orderDetailRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "myPage/order-detail";
    }
}
