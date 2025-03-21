package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.OrderHistoryDto;
import com.wru.wrubookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderHistoryDto> selectOrderHistory(Integer userId, OrderSearchCondition osc) throws Exception {
        return orderRepository.selectOrderHistory(Map.of("userId", userId, "osc", osc));
    }

    @Override
    public int selectOrderCnt(Integer userId, String statusId) throws Exception {
        return orderRepository.selectOrderCnt(Map.of("userId", userId, "statusId", statusId));
    }
}
