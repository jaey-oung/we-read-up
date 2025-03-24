package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dao.CommentDao;
import com.wru.wrubookstore.dao.NoticeDao;
import com.wru.wrubookstore.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public int getCount(Integer noticeId) throws Exception {
        return commentDao.count(noticeId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer commentId, Integer noticeId, Integer memberId) throws Exception {
//        int rowCnt = noticeDao.updateCommentCnt(noticeId, -1);
//        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
////        throw new Exception("test");
        int rowCnt = commentDao.delete(commentId, memberId);
        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    @Transactional(rollbackFor = Exception.class)
    public int write(CommentDto commentDto) throws Exception {
//        noticeDao.updateCommentCnt(commentDto.getBno(), 1);
//                throw new Exception("test");
        return commentDao.insert(commentDto);
    }

    public List<CommentDto> getList(Integer noticeId) throws Exception {
//        throw new Exception("test");
        return commentDao.selectAll(noticeId);
    }

    public CommentDto read(Integer commentId) throws Exception {
        return commentDao.select(commentId);
    }

    public int modify(CommentDto commentDto) throws Exception {
        return commentDao.update(commentDto);
    }
}
