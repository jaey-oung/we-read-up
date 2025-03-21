package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.*;
import com.wru.wrubookstore.repository.DeliveryRepository;
import com.wru.wrubookstore.repository.OrderRepository;
import com.wru.wrubookstore.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final DeliveryRepository deliveryRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository, DeliveryRepository deliveryRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<OrderHistoryDto> selectOrderHistory(Integer userId, OrderSearchCondition osc) throws Exception {
        return orderRepository.selectOrderHistory(Map.of("userId", userId, "osc", osc));
    }

    @Override
    public int selectOrderCnt(Integer userId, OrderSearchCondition osc) throws Exception {
        return orderRepository.selectOrderCnt(Map.of("userId", userId, "osc", osc));
    }

    @Override
    public OrderDetailDto selectOrderDetail(Integer orderId) throws Exception {
        OrderDto orderDto = orderRepository.select(orderId);
        PaymentDto paymentDto = paymentRepository.select(orderId);
        List<OrderBookDto> orderBookDtoList = orderRepository.selectOrderBook(orderId);
        DeliveryDto deliveryDto = deliveryRepository.select(orderId);

        return new OrderDetailDto(orderDto, paymentDto, orderBookDtoList, deliveryDto);
    }
}
