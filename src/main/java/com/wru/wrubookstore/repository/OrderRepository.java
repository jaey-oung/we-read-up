package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.OrderHistoryDto;

import java.util.List;
import java.util.Map;

public interface OrderRepository {

    List<OrderHistoryDto> selectOrderHistory(Map<String, Object> map) throws Exception;
    int selectOrderCnt(Map<String, Object> map) throws Exception;
}
