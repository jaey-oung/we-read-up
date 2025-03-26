package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.request.order.OrderDetailRequest;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;
import com.wru.wrubookstore.dto.request.order.OrderPaymentRequest;
import com.wru.wrubookstore.service.MemberService;
import com.wru.wrubookstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;

    public OrderController(OrderService orderService, MemberService memberService) {
        this.orderService = orderService;
        this.memberService = memberService;
    }

    @GetMapping("/myPage/orderList")
    public String orderList(@SessionAttribute Integer userId, Model model, @ModelAttribute OrderSearchCondition osc) {
        try {
            // 주문 상태와 날짜 조건에 따른 총 게시물 개수
            int orderCnt = orderService.selectCntByOsc(userId, osc);
            // PageHandler 생성
            PageHandler ph = new PageHandler(orderCnt, osc.getPage(), 4);
            // 검색 조건에 offset 설정
            osc.setOffset(osc.getPageSize() * (osc.getPage() - 1));
            // 주문 상태와 날짜 조건 페이징에 따른 게시물 리스트
            List<OrderHistoryRequest> orderHistoryRequest = orderService.selectListByOsc(userId, osc);

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

    @GetMapping("/myPage/exchangeRefundList")
    public String exchangeRefundList() {

        return "myPage/exchange-refund-list";
    }

    @GetMapping("/order")
    public String order(@SessionAttribute Integer userId, Model model) {
        try {
            Integer memberId = memberService.selectMember(userId).getMemberId();

            OrderPaymentRequest orderPaymentRequest = orderService.selectOrderPayment(memberId);

            model.addAttribute("orderPaymentRequest", orderPaymentRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "order/order";
    }
}
