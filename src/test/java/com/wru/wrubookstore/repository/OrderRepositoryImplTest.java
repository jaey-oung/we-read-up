package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryImplTest {

    @Autowired
    OrderRepository orderRepository;
}