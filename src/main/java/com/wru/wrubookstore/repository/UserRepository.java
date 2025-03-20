package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.UserDto;

import java.util.List;

public interface UserRepository {

    int count(int isMember) throws Exception;
    List<UserDto> selectAll(int isMember) throws Exception;
    void deleteAll(int isMember) throws Exception;
    int insert(UserDto userDto) throws Exception;
    UserDto select(String email, int isMember) throws Exception;
    int update(UserDto userDto) throws Exception;
    int delete(String email, int isMember) throws Exception;
}
