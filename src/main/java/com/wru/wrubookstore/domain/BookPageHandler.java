package com.wru.wrubookstore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookPageHandler extends PageHandler{
    private int bookCnt;
    private int viewBookCnt;

    public BookPageHandler(int totalCnt, int page) {
        super(totalCnt, page);
    }

    public BookPageHandler(int bookCnt, int page, int viewBookCnt) {
        super(bookCnt, page);
        this.viewBookCnt = viewBookCnt;
        this.bookCnt = bookCnt;
    }
}
