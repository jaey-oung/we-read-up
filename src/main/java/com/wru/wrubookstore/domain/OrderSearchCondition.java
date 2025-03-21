package com.wru.wrubookstore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter @Setter
@ToString
public class OrderSearchCondition {

    private int page;
    private int pageSize;
    private int offset;
    private String startDate;
    private String endDate;
    private String statusId;

    public OrderSearchCondition() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -6);
        cal.add(Calendar.DAY_OF_WEEK, 1);

        this.page = 1;
        this.pageSize = 4;
        this.startDate = df.format(new Date(cal.getTimeInMillis()));
        this.endDate = df.format(new Date());
        this.statusId = "A";
    }
}
