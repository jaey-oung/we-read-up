package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.AddressDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressRepositoryImplTest {

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void selectList() throws Exception {
        Integer memberId = 1;

        List<AddressDto> addressDtoList = addressRepository.selectList(memberId);
        AddressDto addressDto = addressDtoList.getFirst();

        assertEquals(addressDto.getName(), "집");
        assertEquals(addressDto.getRecipient(), "김유리");
    }

    @Test
    @Transactional
    public void insertTest() throws Exception {
        AddressDto addressDto = new AddressDto(1, "테스트 배송지", "홍길동", "010-1111-2222", 12345, "서울 강남구", "미왕빌딩 10층", true);
        int insertCnt = addressRepository.insert(addressDto);

        List<AddressDto> addressDtoList = addressRepository.selectList(1);
        AddressDto insertAddressDto = addressDtoList.getLast();

        System.out.println("insertAddressDto = " + insertAddressDto);

        assertEquals(addressDtoList.size(), 2);
        assertEquals(insertAddressDto.getName(), "테스트 배송지");
        assertTrue(insertAddressDto.isDefaultAddress());
    }

    @Test
    public void selectOneTest() throws Exception {
        Integer addressId = 2;

        AddressDto addressDto = addressRepository.selectOne(addressId);

        assertEquals(addressDto.getMemberId(), 3);
        assertEquals(addressDto.getName(), "회사");
        assertEquals(addressDto.getRecipient(), "채성아");
        assertEquals(addressDto.getPhoneNum(), "010-3333-4444");
    }

    @Test
    @Transactional
    public void updateTest() throws Exception {
        Integer addressId = 1;

        AddressDto addressDto = new AddressDto(1, "학원", "김유리", "010-1111-2222", 12345, "서울시 강남구", "역삼동 123-45", false);
        addressDto.setAddressId(addressId);

        int updateCnt = addressRepository.update(addressDto);
        AddressDto updateAddressDto = addressRepository.selectOne(addressId);

        assertEquals(updateCnt, 1);
        assertEquals(updateAddressDto.getMemberId(), 1);
        assertEquals(updateAddressDto.getName(), "학원");
    }

    @Test
    @Transactional
    public void unsetDefaultAddressTest() throws Exception {
        Integer memberId = 1;

        int updateCnt = addressRepository.unsetDefaultAddress(memberId);
        List<AddressDto> addressDtoList = addressRepository.selectList(memberId);
        AddressDto addressDto = addressDtoList.getFirst();

        assertEquals(updateCnt, 1);
        assertFalse(addressDto.isDefaultAddress());
    }
}