package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;

import java.util.List;
import java.util.Map;

public interface OrderRepository {

    /* select */
    // 주문코드를 통해 주문 한 개 조회
    OrderDto select(Integer orderId) throws Exception;
    // 회원코드를 통해 주문 리스트 조회
    List<OrderDto> selectList(Map<String, Object> map) throws Exception;
    // 조건에 따른 주문 내역 조회
    List<OrderHistoryRequest> selectListByOsc(Map<String, Object> map) throws Exception;
    // 주문 개수 조회
    int selectCnt(Integer userId) throws Exception;
    // 조건에 따른 주문 개수 조회
    int selectCntByOsc(Map<String, Object> map) throws Exception;
    // 주문상세조회 -> 주문상품 정보
    List<OrderBookRequest> selectOrderBook(Integer orderId) throws Exception;
}