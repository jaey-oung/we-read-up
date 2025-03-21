package com.wru.wrubookstore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainSearchCondition {
    private Integer page = 1;
    private Integer pageSize = 8;
    private String category;
    private String categoryOption;
    private String keyword = "";
    private String option = "";

    public MainSearchCondition() {}

    public MainSearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }

    public Integer getOffset() {
        return (page - 1) * pageSize;
    }
}
