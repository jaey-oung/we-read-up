package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final String namespace = "com.wru.wrubookstore.mapper.OrderMapper.";
    private final SqlSessionTemplate session;

    public OrderRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    @Override
    public List<OrderHistoryRequest> selectOrderHistory(Map<String, Object> map) throws Exception {
        return session.selectList(namespace + "selectOrderHistory", map);
    }

    @Override
    public int selectOrderCnt(Map<String, Object> map) throws Exception {
        return session.selectOne(namespace + "selectOrderCnt", map);
    }

    @Override
    public OrderDto select(Integer orderId) throws Exception {
        return session.selectOne(namespace + "select", orderId);
    }

    @Override
    public List<OrderBookRequest> selectOrderBook(Integer orderId) throws Exception {
        return session.selectList(namespace + "selectOrderBook", orderId);
    }
}
