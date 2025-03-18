package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> selectList(Integer memberId) throws Exception;
    AddressDto selectOne(Integer addressId) throws Exception;
    int insert(AddressDto addressDto) throws Exception;
    int update(AddressDto addressDto) throws Exception;
}
