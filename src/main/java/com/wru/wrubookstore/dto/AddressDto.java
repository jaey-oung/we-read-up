package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class AddressDto {

    private String name;
    private String recipient;
    private String phoneNum;
    private int zipcode;
    private String mainAddress;
    private String detailAddress;
    private int isDefault;

}
