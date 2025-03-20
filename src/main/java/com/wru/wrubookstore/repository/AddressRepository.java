package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.AddressDto;

import java.util.List;

public interface AddressRepository {

    List<AddressDto> selectList(Integer memberId) throws Exception;
    AddressDto selectOne(Integer addressId) throws Exception;

    int insert(AddressDto addressDto) throws Exception;

    int update(AddressDto addressDto) throws Exception;
    // 해당 회원의 기본 배송지 해제
    int unsetDefaultAddress(Integer memberId) throws Exception;
}
