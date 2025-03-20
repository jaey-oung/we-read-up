package com.wru.wrubookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    private Integer userId;         // 사용자 코드
    private String userStatusId;    // 사용자 상태 코드
    private String email;           // 사용자 이메일
    private String password;        // 사용자 비밀번호
    private String name;            // 사용자 명
    // boolean 타입 사용 시 Lombok이 isMember() 메서드를 자동 생성
    private Boolean isMember;       // 사용자 회원 여부

    public UserDto() {}
    public UserDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
