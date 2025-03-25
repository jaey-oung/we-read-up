package com.wru.wrubookstore.dto;

import java.util.Date;
import java.util.Objects;

public class InquiryDto {

    private Integer inquiryId;
    private Integer memberId;
    private String inquiry_status_id;
    private String employeeID;
    private String title;
    private String content;
    private String replyContent;
    private Date regDate;
    private Date modDate;

    public InquiryDto() {}

    public InquiryDto(Integer inquiryId, Integer memberId, String inquiry_status_id, String employeeID, String title, String content, String replyContent) {
        this.inquiryId = inquiryId;
        this.memberId = memberId;
        this.inquiry_status_id = inquiry_status_id;
        this.employeeID = employeeID;
        this.title = title;
        this.content = content;
        this.replyContent = replyContent;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InquiryDto that)) return false;
        return Objects.equals(inquiryId, that.inquiryId) && Objects.equals(memberId, that.memberId) && Objects.equals(inquiry_status_id, that.inquiry_status_id) && Objects.equals(employeeID, that.employeeID) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(replyContent, that.replyContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquiryId, memberId, inquiry_status_id, employeeID, title, content, replyContent);
    }

    @Override
    public String toString() {
        return "InquiryDto{" +
                "inquiryId=" + inquiryId +
                ", memberId=" + memberId +
                ", inquiry_status_id='" + inquiry_status_id + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", regDate=" + regDate +
                ", modDate=" + modDate +
                '}';
    }

    public Integer getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Integer inquiryId) {
        this.inquiryId = inquiryId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getInquiry_status_id() {
        return inquiry_status_id;
    }

    public void setInquiry_status_id(String inquiry_status_id) {
        this.inquiry_status_id = inquiry_status_id;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }
}
