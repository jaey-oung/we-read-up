package com.wru.wrubookstore.dto.request.order;

import com.wru.wrubookstore.dto.AddressDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class OrderPaymentRequest {

    private AddressDto addressDto;

    public OrderPaymentRequest() {

    }

    public OrderPaymentRequest(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
