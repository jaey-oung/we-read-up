package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.request.order.OrderDetailRequest;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;
import com.wru.wrubookstore.dto.request.order.OrderPaymentRequest;

import java.util.List;

public interface OrderService {

    // 주문 상태, 날짜, 페이징에 따른 게시물 리스트
    List<OrderHistoryRequest> selectListByOsc(Integer userId, OrderSearchCondition osc) throws Exception;
    // 주문 상태, 날짜에 따른 게시물 개수
    int selectCntByOsc(Integer userId, OrderSearchCondition osc) throws Exception;
    // 주문상세 조회
    OrderDetailRequest selectOrderDetail(Integer orderId) throws Exception;
    // 주문/결제 정보 조회
    OrderPaymentRequest selectOrderPayment(Integer memberId) throws Exception;
}
