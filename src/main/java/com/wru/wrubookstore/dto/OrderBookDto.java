package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class OrderBookDto {

    private String image;   // 책 이미지
    private String name;    // 책 이름
    private int orderPrice;  // 주문 가격
    private int quantity;   // 주문 수량
}
