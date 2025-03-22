package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.PaymentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentRepositoryImplTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    public void selectTest() throws Exception {
        Integer orderId = 1;

        PaymentDto paymentDto = paymentRepository.select(orderId);

        assertEquals(paymentDto.getPaymentId(), 1);
        assertEquals(paymentDto.getStatusId(), "PS2");
        assertEquals(paymentDto.getPaymentMethod(), "신용카드");
        assertEquals(paymentDto.getActualPrice(), 17820);
    }
}