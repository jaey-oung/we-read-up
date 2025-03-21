package com.wru.wrubookstore.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"email", "password", "name", "nickname", "phoneNum", "birthdate", "gender", "image"})
public class MemberDto {
    private Integer memberId;       // 회원 코드
    private Integer userId;         // 사용자 코드
    private String userStatusId;    // 사용자 상태 코드
    private String email;           // 사용자 이메일
    private String password;        // 사용자 비밀번호
    private String name;            // 사용자 명
    // boolean 타입 사용 시 Lombok이 isMember() 메서드를 자동 생성
    private Boolean isMember;       // 사용자 회원 여부
    private String membershipId;    // 회원 멤버십 코드
    private String nickname;        // 회원 닉네임
    private String phoneNum;        // 회원 전화번호
    private LocalDate birthdate;   // 회원 생년월일
    private LocalDate regDate;      // 회원 등록 날짜
    private LocalDate modDate;     // 회원 수정 날짜
    private char gender;          // 회원 성별
    private int mileage;            // 회원 보유 마일리지
    private int lastMonthAmount;    // 회원 전월 구매 금액
    private String image;           // 회원 이미지

    public MemberDto() {}
    public MemberDto(String email, String password, String name, String nickname, String phoneNum, LocalDate birthdate, char gender, String image) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.phoneNum = phoneNum;
        this.birthdate = birthdate;
        this.gender = gender;
        this.image = image;
    }

}
