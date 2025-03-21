package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.OrderHistoryDto;
import com.wru.wrubookstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            int orderCnt = orderService.selectOrderCnt(userId, osc.getStatusId());
            PageHandler ph = new PageHandler(orderCnt, osc.getPage(), 4);
            osc.setOffset(osc.getPageSize() * (osc.getPage() - 1));
            List<OrderHistoryDto> orderHistoryDto = orderService.selectOrderHistory(userId, osc);

            model.addAttribute("orderList", orderHistoryDto);
            model.addAttribute("osc", osc);
            model.addAttribute("ph", ph);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "myPage/order-list";
    }

    @GetMapping("/myPage/orderDetail")
    public String orderDetail() {

        return "myPage/order-detail";
    }
}
