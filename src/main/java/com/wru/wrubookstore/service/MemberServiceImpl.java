package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.MemberDto;
import com.wru.wrubookstore.dto.UserDto;
import com.wru.wrubookstore.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int count() throws Exception {
        return memberRepository.count();
    }

    @Override
    public List<MemberDto> selectAll() throws Exception {
        return memberRepository.selectAll();
    }

    @Override
    public void deleteAllMembers() throws Exception {
        memberRepository.deleteAllMembers();
    }

    @Override
    public void deleteAllUsers() throws Exception {
        memberRepository.deleteAllUsers();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(UserDto userDto, MemberDto memberDto) throws Exception {
        int rowCnt1 = memberRepository.insertUser(userDto);

        if (rowCnt1 != 1)
            throw new Exception("사용자 테이블에 회원 계정 생성 실패");

        int rowCnt2 = memberRepository.insertMember(memberDto);

        if (rowCnt2 != 1)
            throw new Exception("회원 테이블에 회원 계정 생성 실패");
    }

    @Override
    public MemberDto select(String email) throws Exception {
        return memberRepository.select(email);
    }

    @Override
    public MemberDto selectByUserId(int userId) throws Exception {
        return memberRepository.selectByUserId(userId);
    }

    @Override
    public int updateUser(UserDto userDto) throws Exception {
        return memberRepository.updateUser(userDto);
    }

    @Override
    public int updateMember(MemberDto memberDto) throws Exception {
        return memberRepository.updateMember(memberDto);
    }

    @Override
    public int deleteMember(String email) throws Exception {
        return memberRepository.deleteMember(email);
    }

    @Override
    public int deleteUser(String email) throws Exception {
        return memberRepository.deleteUser(email);
    }

    @Override
    public int countMembers() throws Exception {
        return memberRepository.countMembers();
    }

}
