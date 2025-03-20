package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.OrderHistoryDto;

import java.util.List;

public interface OrderService {

    List<OrderHistoryDto> selectOrderHistory(Integer userId, OrderSearchCondition osc) throws Exception;
}
