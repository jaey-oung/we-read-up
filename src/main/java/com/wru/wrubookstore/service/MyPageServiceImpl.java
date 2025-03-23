package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.MemberDto;
import com.wru.wrubookstore.dto.MembershipDto;
import com.wru.wrubookstore.dto.OrderDto;
import com.wru.wrubookstore.dto.request.MyPageRequest;
import com.wru.wrubookstore.repository.*;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MyPageServiceImpl implements MyPageService {

    private final MemberRepository memberRepository;
    private final MembershipRepository membershipRepository;
    private final CouponRepository couponRepository;
    private final OrderRepository orderRepository;
    private final ExchangeRepository exchangeRepository;
    private final RefundRepository refundRepository;

    public MyPageServiceImpl(MemberRepository memberRepository, MembershipRepository membershipRepository, CouponRepository couponRepository, OrderRepository orderRepository, ExchangeRepository exchangeRepository, RefundRepository refundRepository) {
        this.memberRepository = memberRepository;
        this.membershipRepository = membershipRepository;
        this.couponRepository = couponRepository;
        this.orderRepository = orderRepository;
        this.exchangeRepository = exchangeRepository;
        this.refundRepository = refundRepository;
    }

    @Override
    public MyPageRequest selectMyPageInfo(Integer userId, boolean isMember) throws Exception {
        MemberDto memberDto = memberRepository.selectMember(userId);        // 회원 정보
        MembershipDto membershipDto = membershipRepository.select(userId);  // 멤버십 정보
        int couponCnt = couponRepository.selectCount(userId);               // 쿠폰 개수
        int orderCnt = orderRepository.selectCnt(userId);                   // 주문 개수
        List<OrderDto> orderDtoList = orderRepository.selectList(getSixMonthSummaryMap(userId));   // 주문 리스트
        int orderDs1Cnt = 0;                                                // 배송준비중 개수
        int orderDs2Cnt = 0;                                                // 배송중 개수
        int orderDs3Cnt = 0;                                                // 배송완료 개수
        int exchangeCnt = exchangeRepository.selectCnt(userId);             // 교환 개수
        int refundCnt = refundRepository.selectCnt(userId);                 // 환불 개수

        // 회원과 비회원 출력 정보가 다름
        if (isMember) {

            // 배송 상태에 따른 개수 출력
            for (OrderDto orderDto : orderDtoList) {
                switch (orderDto.getStatusId()) {
                    case "DS1":
                        orderDs1Cnt++;
                        break;
                    case "DS2":
                        orderDs2Cnt++;
                        break;
                    default:
                        orderDs3Cnt++;
                }
            }

            return new MyPageRequest(memberDto.getImage(), membershipDto.getName(), memberDto.getMileage(), couponCnt, orderCnt, orderDs1Cnt, orderDs2Cnt, orderDs3Cnt, exchangeCnt, refundCnt);
        }
        else {
            return null;
        }
    }

    // userId, startDate, endDate 6개월 차이로 만드는 Map 출력
    private static Map<String, Object> getSixMonthSummaryMap(Integer userId) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -6);
        cal.add(Calendar.DAY_OF_WEEK, 1);
        Date startDate = new Date(cal.getTimeInMillis());
        Date endDate = new Date();

        System.out.println("startDate = " + startDate);
        System.out.println("endDate = " + endDate);

        return Map.of("userId", userId, "startDate", startDate, "endDate", endDate);
    }
}
