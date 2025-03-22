package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.MemberDto;
import com.wru.wrubookstore.dto.UserDto;

import java.util.List;

public interface MemberService {

    int count() throws Exception;
    List<MemberDto> selectAll() throws Exception;
    void deleteAllMembers() throws Exception;
    void deleteAllUsers() throws Exception;
    void insert(UserDto userDto, MemberDto memberDto) throws Exception;
    MemberDto select(String email) throws Exception;
    MemberDto selectByUserId(int userId) throws Exception;
    int updateUser(UserDto userDto) throws Exception;
    int updateMember(MemberDto memberDto) throws Exception;
    int deleteMember(String email) throws Exception;
    int deleteUser(String email) throws Exception;
    int countMembers() throws Exception;

}
