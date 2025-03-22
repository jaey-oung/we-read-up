package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.MemberDto;
import com.wru.wrubookstore.dto.UserDto;

import java.util.List;

public interface MemberRepository {

    int count() throws Exception;
    List<MemberDto> selectAll() throws Exception;
    void deleteAllMembers() throws Exception;
    void deleteAllUsers() throws Exception;
    int insertUser(UserDto userDto) throws Exception;
    int insertMember(MemberDto memberDto) throws Exception;
    MemberDto select(String email) throws Exception;
    MemberDto selectMember(Integer userId) throws Exception;
    int updateUser(UserDto userDto) throws Exception;
    int updateMember(MemberDto memberDto) throws Exception;
    int deleteMember(String email) throws Exception;
    int deleteUser(String email) throws Exception;
    int countMembers() throws Exception;

}
