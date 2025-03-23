package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.request.MyPageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyPageServiceImplTest {

    @Autowired
    MyPageService myPageService;

    @Test
    public void selectMyPageInfoTest() throws Exception {
        Integer userId = 3;
        boolean isMember = true;

        MyPageRequest myPageRequest = myPageService.selectMyPageInfo(userId, isMember);

        assertEquals(myPageRequest.getMembershipName(), "BRONZE");
        assertEquals(myPageRequest.getMileage(), 0);
        assertEquals(myPageRequest.getCouponCnt(), 3);
        assertEquals(myPageRequest.getOrderCnt(), 16);
        assertEquals(myPageRequest.getOrderDs1Cnt(), 1);
        assertEquals(myPageRequest.getOrderDs2Cnt(), 5);
        assertEquals(myPageRequest.getOrderDs3Cnt(), 10);
        assertEquals(myPageRequest.getExchangeCnt(), 0);
        assertEquals(myPageRequest.getRefundCnt(), 1);
    }
}