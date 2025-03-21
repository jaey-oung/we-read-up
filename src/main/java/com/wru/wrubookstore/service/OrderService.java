package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.OrderDetailDto;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.OrderHistoryDto;

import java.util.List;

public interface OrderService {

    // 주문 상태, 날짜, 페이징에 따른 게시물 리스트
    List<OrderHistoryDto> selectOrderHistory(Integer userId, OrderSearchCondition osc) throws Exception;
    // 주문 상태, 날짜에 따른 게시물 개수
    int selectOrderCnt(Integer userId, OrderSearchCondition osc) throws Exception;
    // 주문상세조회
    OrderDetailDto selectOrderDetail(Integer orderId) throws Exception;
}
