package com.wru.wrubookstore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PageHandler {
    private Integer page;           // 현재 페이지
    private Integer pageSize;       // 페이지 크기
    private Integer viewBookCnt;    // 보여줄 책의 수

    private int bookCnt;            // 총 게시물 수
    private int totalPage;          // 총 페이지 수
    private int nav = 10;            // 페이지바 크기
    private int beginPage;          // 시작 페이지
    private int endPage;            // 끝 페이지
    private boolean nextPage;       // 다음 페이지가 있는지
    private boolean prevPage;       // 이전 페이지가 있는지

    public PageHandler(){}          // 기본 생성자

    public PageHandler(int bookCnt, int page, int pageSize, int viewBookCnt){
        this.bookCnt = bookCnt;
        this.page = page;
        this.pageSize = pageSize;
        this.viewBookCnt = viewBookCnt;

        totalPage = (int)Math.ceil(bookCnt/(double)pageSize);
        beginPage = (page-1)/pageSize*pageSize+1;
        endPage = Math.min(beginPage+pageSize-1,totalPage);
        nextPage = endPage < totalPage;
        prevPage = beginPage > 1;
    }
}
