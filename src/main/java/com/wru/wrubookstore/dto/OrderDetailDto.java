package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class OrderDetailDto {

    private OrderDto orderDto;
    private PaymentDto paymentDto;
    private List<OrderBookDto> orderBookDtoList;
    private DeliveryDto deliveryDto;

    public OrderDetailDto() {

    }

    public OrderDetailDto(OrderDto orderDto, PaymentDto paymentDto, List<OrderBookDto> orderBookDtoList, DeliveryDto deliveryDto) {
        this.orderDto = orderDto;
        this.paymentDto = paymentDto;
        this.orderBookDtoList = orderBookDtoList;
        this.deliveryDto = deliveryDto;
    }
}
