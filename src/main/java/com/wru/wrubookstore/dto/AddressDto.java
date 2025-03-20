package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class AddressDto {

    private Integer addressId;
    private Integer memberId;
    private String name;
    private String recipient;
    private String phoneNum;
    private int zipCode;
    private String mainAddress;
    private String detailAddress;
    private boolean defaultAddress;

    public AddressDto() {
    }

    public AddressDto(Integer memberId, String name, String recipient, String phoneNum, int zipCode, String mainAddress, String detailAddress, boolean defaultAddress) {
        this.memberId = memberId;
        this.name = name;
        this.recipient = recipient;
        this.phoneNum = phoneNum;
        this.zipCode = zipCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
        this.defaultAddress = defaultAddress;
    }
}
