package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.CouponDto;

import java.util.List;

public interface CouponRepository {
    List<CouponDto> selectList(Integer memberId);
}
