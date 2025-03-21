package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.DeliveryDto;

public interface DeliveryRepository {

    // 주문번호로 배송 한 개 검색
    DeliveryDto select(Integer orderId) throws Exception;
}
