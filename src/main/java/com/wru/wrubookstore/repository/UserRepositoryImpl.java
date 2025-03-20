package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.UserDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    private final String namespace = "com.wru.wrubookstore.mapper.UserMapper.";
    private final SqlSessionTemplate session;

    public UserRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public List<UserDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public void deleteAll() throws Exception {
        session.delete(namespace+"deleteAll");
    }

    @Override
    public int insert(UserDto userDto) throws Exception {
        return session.insert(namespace+"insert", userDto);
    }

    @Override
    public UserDto select(String email) throws Exception {
        return session.selectOne(namespace+"select", email);
    }

    @Override
    public int update(UserDto userDto) throws Exception {
        return session.update(namespace+"update", userDto);
    }

    @Override
    public int delete(String email) throws Exception {
        return session.delete(namespace+"delete", email);
    }

}
