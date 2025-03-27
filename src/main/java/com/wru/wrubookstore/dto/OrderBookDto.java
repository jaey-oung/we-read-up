package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class OrderBookDto {

    private Integer orderBookId;
    private Integer orderId;
    private Integer bookId;
    private int quantity;
    private int price;

    public OrderBookDto() {

    }

    public OrderBookDto(Integer orderId, Integer bookId, int quantity, int price) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;
    }
}
