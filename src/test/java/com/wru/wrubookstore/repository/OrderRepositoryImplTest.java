package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.domain.OrderSearchCondition;
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

    @Test
    public void selectOrderHistoryTest() throws Exception {
        Integer userId = 1;
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
        Integer userId = 1;
        OrderSearchCondition osc = new OrderSearchCondition();
        osc.setStatusId("DS2");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("osc", osc);

        List<OrderHistoryDto> orderHistory = orderRepository.selectOrderHistory(map);

        assertEquals(orderHistory.size(), 0);
    }
}