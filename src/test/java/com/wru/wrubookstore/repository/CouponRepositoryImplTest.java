package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.CouponDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponRepositoryImplTest {

    @Autowired
    CouponRepository couponRepository;

    @Test
    public void selectListTest() throws Exception {
        Integer memberId = 1;

        List<CouponDto> couponDtoList = couponRepository.selectList(memberId);

        assertEquals(couponDtoList.size(), 3);
    }
}