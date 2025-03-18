package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString
public class CouponDto {

    private Integer couponId;
    private String name;
    private double discount;
    private int maxDiscountAmount;
    private int minDiscountAmount;
    private Date regDate;
    private Date endDate;
}
