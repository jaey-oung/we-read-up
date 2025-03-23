package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString
public class OrderDto {

    private Integer orderId;
    private Integer userId;
    private String userName;
    private String statusId;
    private Date regDate;
    private Date endDate;
}
