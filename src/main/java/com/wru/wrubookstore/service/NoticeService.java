package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dao.NoticeDao;
import com.wru.wrubookstore.dto.NoticeDto;
import com.wru.wrubookstore.domain.SearchCondition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeService {

    private final NoticeDao noticeDao;

    public NoticeService(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    public int getCount() throws Exception {
        return noticeDao.count();
    }

    public int remove(Integer noticeId, String employeeId) throws Exception {
        return noticeDao.delete(noticeId, employeeId);
    }

    public int write(NoticeDto noticeDto) throws Exception {
//        throw new Exception("test");      // 쓰기 실패 테스트를 위한 예외 던지기
        return noticeDao.insert(noticeDto);
    }

    public List<NoticeDto> getList() throws Exception {
        return noticeDao.selectAll();
    }

    public NoticeDto read(Integer bno) throws Exception {
        NoticeDto noticeDto = noticeDao.select(bno);
        noticeDao.increaseViewCnt(bno);

        return noticeDto;
    }

    public List<NoticeDto> getPage(Map map) throws Exception {
        return noticeDao.selectPage(map);
    }

    public int modify(NoticeDto noticeDto) throws Exception {
        return noticeDao.update(noticeDto);
    }

    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return noticeDao.searchResultCnt(sc);
    }

    public List<NoticeDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return noticeDao.searchSelectPage(sc);
    }


}
