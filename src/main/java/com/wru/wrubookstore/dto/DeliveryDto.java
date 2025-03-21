package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString
public class DeliveryDto {

    private Integer deliveryId;
    private Integer orderId;
    private String statusId;
    private String recipient;
    private String phoneNum;
    private int zipCode;
    private String mainAddress;
    private String detailAddress;
    private String message;
    private Date regDate;
    private Date endDate;
}
