package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.DeliveryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeliveryRepositoryImplTest {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Test
    public void selectTest() throws Exception {
        Integer orderId = 1;

        DeliveryDto deliveryDto = deliveryRepository.select(orderId);

        assertEquals(deliveryDto.getDeliveryId(), 1);
        assertEquals(deliveryDto.getStatusId(), "DS1");
        assertEquals(deliveryDto.getRecipient(), "김신");
        assertEquals(deliveryDto.getPhoneNum(), "010-2020-2020");
        assertEquals(deliveryDto.getZipCode(), 12345);
        assertEquals(deliveryDto.getMainAddress(), "서울시 강남구");
        assertEquals(deliveryDto.getDetailAddress(), "청담동 234");
    }
}