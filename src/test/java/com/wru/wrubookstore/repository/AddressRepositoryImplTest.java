package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.AddressDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}