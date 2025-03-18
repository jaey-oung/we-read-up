package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.AddressDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private final String namespace = "com.wru.wrubookstore.mapper.AddressMapper.";
    private final SqlSessionTemplate session;

    public AddressRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    @Override
    public List<AddressDto> selectList(Integer memberId) throws Exception {
        return session.selectList(namespace + "selectList", memberId);
    }

    @Override
    public int insert(AddressDto addressDto) throws Exception {
        return session.insert(namespace + "insert", addressDto);
    }
}
