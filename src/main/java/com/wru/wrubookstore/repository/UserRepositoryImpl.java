package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.UserDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRepositoryImpl implements UserRepository {

    private final String namespace = "com.wru.wrubookstore.mapper.UserMapper.";
    private final SqlSessionTemplate session;

    public UserRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    @Override
    public int count(int isMember) throws Exception {
        return session.selectOne(namespace+"count", isMember);
    }

    @Override
    public List<UserDto> selectAll(int isMember) throws Exception {
        return session.selectList(namespace+"selectAll", isMember);
    }

    @Override
    public void deleteAll(int isMember) throws Exception {
        session.delete(namespace+"deleteAll", isMember);
    }

    @Override
    public int insert(UserDto userDto) throws Exception {
        return session.insert(namespace+"insert", userDto);
    }

    @Override
    public UserDto select(String email, int isMember) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("isMember", isMember);
        return session.selectOne(namespace+"select", map);
    }

    @Override
    public int update(UserDto userDto) throws Exception {
        return session.update(namespace+"update", userDto);
    }

    @Override
    public int delete(String email, int isMember) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("isMember", isMember);
        return session.delete(namespace+"delete", map);
    }
}
