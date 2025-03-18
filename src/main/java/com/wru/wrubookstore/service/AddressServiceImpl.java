package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.AddressDto;
import com.wru.wrubookstore.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDto> selectList(Integer memberId) throws Exception {
        return addressRepository.selectList(memberId);
    }

    @Override
    public AddressDto selectOne(Integer addressId) throws Exception {
        return addressRepository.selectOne(addressId);
    }

    @Override
    public int insert(AddressDto addressDto) throws Exception {
        return addressRepository.insert(addressDto);
    }

    @Override
    public int update(AddressDto addressDto) throws Exception {
        return addressRepository.update(addressDto);
    }
}
