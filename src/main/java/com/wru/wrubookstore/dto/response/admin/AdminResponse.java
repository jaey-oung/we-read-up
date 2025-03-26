package com.wru.wrubookstore.dto.response.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class AdminResponse {
    private Integer bookId;             // 책 코드 PK Auto_Increment
    private String publisherId;         // 출판사 코드
    private String categorySmallId;     // 소_카테고리 코드
    private String name;                // 책 이름
    private String translator;          // 역자
    private int originalPrice;          // 정가
    private BigDecimal discountPercent; // 할인율 1 ~ 0.00
    private int discountPrice;          // 할인되는 가격
    private int salePrice;              // 판매가
    private Date releaseDate;           // 등록일
    private Date regDate;               // 판매일
    private String image;               // 도서의 이미지

    private String tableOfContent;      // 도서 목차
    private String description;         // 도서 소개
    private long isbn;                  // 책 고유번호
    private int stockQuantity;          // 재고 수량
    private String size;                // 도서 사이즈
    private int weight;                 // 도서 무게
    private int page;                   // 도서 페이지 수


    private String publisherName;       // 출판사 이름
    private String president;           // 대표
    private String bizRegNo;            // 사업자번호
    private String mainAddress;         // 기본 주소
    private String detailAddress;       // 상세 주소
    private int zipCode;                // 우편번호
    private String phoneNum;            // 폰번호
    private String bizArea;             // 출판사 국적

    private String writerId;            // 지은이 코드
    private String writerName;          // 지은이 이름
    private String writerDescription;   // 지은이 설명
    private char gender;                // M,F 남여
    private String nationality;         // 국적
    private String nickname;            // 닉네임

    AdminResponse(){}
}
