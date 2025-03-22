package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.request.order.OrderDetailRequest;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;

import java.util.List;

public interface OrderService {

    // 주문 상태, 날짜, 페이징에 따른 게시물 리스트
    List<OrderHistoryRequest> selectOrderHistory(Integer userId, OrderSearchCondition osc) throws Exception;
    // 주문 상태, 날짜에 따른 게시물 개수
    int selectOrderCnt(Integer userId, OrderSearchCondition osc) throws Exception;
    // 주문상세조회
    OrderDetailRequest selectOrderDetail(Integer orderId) throws Exception;
}
