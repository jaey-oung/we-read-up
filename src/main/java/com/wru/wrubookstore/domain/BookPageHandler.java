package com.wru.wrubookstore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookPageHandler extends PageHandler{
    private int bookCnt;        // 도서 개수
    private int viewBookCnt;    // 보여줄 도서 개수

    public BookPageHandler(int totalCnt, int page) {
        super(totalCnt, page);
    }

    public BookPageHandler(int bookCnt, int page, int viewBookCnt) {
        super(bookCnt, page);
        this.viewBookCnt = viewBookCnt;
        this.bookCnt = bookCnt;
    }
}
