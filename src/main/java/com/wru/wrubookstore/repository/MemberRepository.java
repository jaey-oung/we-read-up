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
    int insertUserWithId(MemberDto memberDto) throws Exception;
    int insertMember(MemberDto memberDto) throws Exception;
    MemberDto select(Integer userId) throws Exception;
    MemberDto selectMember(Integer userId) throws Exception;
    int updateUser(MemberDto memberDto) throws Exception;
    int updateMember(MemberDto memberDto) throws Exception;
    int deleteMember(Integer userId) throws Exception;
    int deleteUser(Integer userId) throws Exception;
    int countMembers() throws Exception;

}
