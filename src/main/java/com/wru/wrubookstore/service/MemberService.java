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
    MemberDto select(Integer userId) throws Exception;
    MemberDto selectMember(Integer userId) throws Exception;
    int updateUser(MemberDto memberDto) throws Exception;
    int updateMember(MemberDto memberDto) throws Exception;
    int deleteMember(Integer userId) throws Exception;
    int deleteUser(Integer userId) throws Exception;
    int countMembers() throws Exception;

    void editMember(MemberDto memberDto) throws Exception;
    void withdraw(Integer userId) throws Exception;
}
