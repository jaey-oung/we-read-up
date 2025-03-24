package com.wru.wrubookstore.dto;

import java.util.Date;
import java.util.Objects;

public class CommentDto {
    private Integer commentId;
    private Integer memberId;
    private String nickname;
    private Integer noticeId;
    private String content;
    private Date regDate;
    private Date modDate;

    public CommentDto() {    }

    public CommentDto(Integer memberId, String nickdname, Integer noticeId, String content) {
        this.memberId = memberId;
        this.nickname = nickdname;
        this.noticeId = noticeId;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CommentDto that)) return false;
        return Objects.equals(commentId, that.commentId) && Objects.equals(memberId, that.memberId) && Objects.equals(nickname, that.nickname) && Objects.equals(noticeId, that.noticeId) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, memberId, nickname, noticeId, content);
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
//    public CommentDto() {    }
//    public CommentDto(Integer memberId, Integer noticeId, String content) {
//        this.memberId = memberId;
//        this.noticeId = noticeId;
//        this.content = content;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof CommentDto that)) return false;
//        return Objects.equals(commentId, that.commentId) && Objects.equals(memberId, that.memberId) && Objects.equals(noticeId, that.noticeId) && Objects.equals(content, that.content);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(commentId, memberId, noticeId, content);
//    }
//
//    @Override
//    public String toString() {
//        return "CommentDto{" +
//                "commentId=" + commentId +
//                ", memberId=" + memberId +
//                ", noticeId=" + noticeId +
//                ", content='" + content + '\'' +
//                ", regDate=" + regDate +
//                ", modDate=" + modDate +
//                '}';
//    }
//
//    public Integer getCommentId() {
//        return commentId;
//    }
//
//    public void setCommentId(Integer commentId) {
//        this.commentId = commentId;
//    }
//
//    public Integer getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Integer memberId) {
//        this.memberId = memberId;
//    }
//
//    public Integer getNoticeId() {
//        return noticeId;
//    }
//
//    public void setNoticeId(Integer noticeId) {
//        this.noticeId = noticeId;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Date getRegDate() {
//        return regDate;
//    }
//
//    public void setRegDate(Date regDate) {
//        this.regDate = regDate;
//    }
//
//    public Date getModDate() {
//        return modDate;
//    }
//
//    public void setModDate(Date modDate) {
//        this.modDate = modDate;
//    }
}
