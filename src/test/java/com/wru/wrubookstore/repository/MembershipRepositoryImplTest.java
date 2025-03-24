package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.MembershipDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MembershipRepositoryImplTest {

    @Autowired
    MembershipRepository membershipRepository;

    @Test
    public void selectTest() throws Exception {
        Integer userId = 3;

        MembershipDto membershipDto = membershipRepository.select(userId);

        assertEquals(membershipDto.getMembershipId(), "mem_1");
        assertEquals(membershipDto.getName(), "BRONZE");
        assertEquals(membershipDto.getMileagePercent(), 0.05);
        assertEquals(membershipDto.getMembershipCriteria(), 0);
    }

}