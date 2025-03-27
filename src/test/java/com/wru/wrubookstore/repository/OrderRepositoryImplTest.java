package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.BookDto;
import com.wru.wrubookstore.dto.OrderBookDto;
import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryImplTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    @Transactional
    public void insertOrderTest() throws Exception {
        Integer userId = 3;
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(userId);

        int insertCnt = orderRepository.insertOrder(orderDto);

        System.out.println("orderDto.getOrderId() = " + orderDto.getOrderId());
        assertEquals(insertCnt, 1);
    }
}