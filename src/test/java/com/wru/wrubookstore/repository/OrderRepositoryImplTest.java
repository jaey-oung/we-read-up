package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.OrderBookDto;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.OrderHistoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryImplTest {

    @Autowired
    OrderRepository orderRepository;
    Integer userId = 1;
    Integer orderId = 1;

    @Test
    public void selectOrderHistoryTest() throws Exception {
        OrderSearchCondition osc = new OrderSearchCondition();
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("osc", osc);

        List<OrderHistoryDto> orderHistory1 = orderRepository.selectOrderHistory(map);
        OrderHistoryDto order = orderHistory1.getFirst();

        assertEquals(order.getOrderId(), 1);
        assertEquals(order.getUserName(), "홍길동");
        assertEquals(order.getBookName(), "인생 뭐, 야구");
    }

    @Test
    public void selectOrderHistoryTest2() throws Exception {
        OrderSearchCondition osc = new OrderSearchCondition();
        osc.setStatusId("DS2");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("osc", osc);

        List<OrderHistoryDto> orderHistory = orderRepository.selectOrderHistory(map);

        assertEquals(orderHistory.size(), 0);
    }

    @Test
    public void selectOrderCnt() throws Exception {
        Integer userId = 3;
        String statusId = "A";
        String startDate = "2025-03-18";
        String endDate = "2025-03-20";
        OrderSearchCondition osc = new OrderSearchCondition(startDate, endDate, statusId);

        int orderCnt = orderRepository.selectOrderCnt(Map.of("userId", userId, "osc", osc));

        assertEquals(orderCnt, 15);
    }

    @Test
    public void selectTest() throws Exception {
        OrderDto orderDto = orderRepository.select(orderId);

        assertEquals(orderDto.getUserName(), "홍길동");
        assertEquals(orderDto.getStatusId(), "DS1");
        System.out.println("orderDto.getRegDate() = " + orderDto.getRegDate());
    }

    @Test
    public void selectOrderBookTest() throws Exception {
        List<OrderBookDto> orderBookDtoList = orderRepository.selectOrderBook(orderId);
        OrderBookDto firstOrderBookDto = orderBookDtoList.getFirst();
        OrderBookDto lastOrderBookDto = orderBookDtoList.getLast();

        assertEquals(orderBookDtoList.size(), 2);
        assertEquals(firstOrderBookDto.getName(), "인생은 순간이다");
        assertEquals(firstOrderBookDto.getOrderPrice(), 17820);
        assertEquals(firstOrderBookDto.getQuantity(), 1);
        assertEquals(lastOrderBookDto.getName(), "인생 뭐, 야구");
        assertEquals(lastOrderBookDto.getOrderPrice(), 84150);
        assertEquals(lastOrderBookDto.getQuantity(), 5);
    }
}