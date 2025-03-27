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
    private String waybill;

    public DeliveryDto() {

    }

    public DeliveryDto(Integer orderId, String recipient, String phoneNum, int zipCode, String mainAddress, String detailAddress, String message) {
        this.orderId = orderId;
        this.recipient = recipient;
        this.phoneNum = phoneNum;
        this.zipCode = zipCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
        this.message = message;
    }
}
