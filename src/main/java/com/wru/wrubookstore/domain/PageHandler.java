package com.wru.wrubookstore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PageHandler {

    private int totalCnt;
    private int totalPage;
    private int page;
    private int pageSize = 10;
    private int naviSize = 10;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;

    public PageHandler(int totalCnt, int page) {
        this.totalCnt = totalCnt;
        this.page = page;
        totalPage = (int) Math.ceil((double)totalCnt / pageSize);
        beginPage = (page - 1) / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
        showPrev = page != 1;
        showNext = page != totalPage && totalPage != 0;
    }
}