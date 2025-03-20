package com.wru.wrubookstore.dao;

import com.wru.wrubookstore.dto.NoticeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoticeDaoTest {

    @Autowired
    private NoticeDao noticeDao;

    @Test
    public void select() throws Exception{
        assertTrue(noticeDao!=null);
        System.out.println("noticeDao = " + noticeDao);
        NoticeDto noticeDto = noticeDao.select(1);
        System.out.println("noticeDto = " + noticeDto);
//        assertTrue(noticeDto.getNotice_id().equals(1));
    }
}