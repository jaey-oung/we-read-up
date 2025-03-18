package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.CouponDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final String namespace = "com.wru.wrubookstore.mapper.CouponMapper.";
    private final SqlSessionTemplate session;

    public CouponRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    @Override
    public List<CouponDto> selectList(Integer memberId) throws Exception {
        return session.selectList(namespace + "selectList", memberId);
    }
}
