package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;

import java.util.List;
import java.util.Map;

public interface OrderRepository {

    // 조건에 따른 주문 내역 조회
    List<OrderHistoryRequest> selectOrderHistory(Map<String, Object> map) throws Exception;
    // 조건에 따른 주문 개수 조회
    int selectOrderCnt(Map<String, Object> map) throws Exception;
    // 주문상세조회 -> 주문 정보
    OrderDto select(Integer orderId) throws Exception;
    // 주문상세조회 -> 주문상품 정보
    List<OrderBookRequest> selectOrderBook(Integer orderId) throws Exception;
}