package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.domain.MainSearchCondition;
import com.wru.wrubookstore.dto.BookDto;

import java.util.List;
import java.util.Map;

public interface BookRepository {
    // 책 번호로 한개 조회
    BookDto select(Integer bookId) throws Exception;

    // LIMIT로 N개 조회 category(카테고리 소), offset, limit
    List<BookDto> selectRegList(Map map) throws Exception;

    // 카테고리에 있는 책 수 조회
    int sCategoryCnt(String category) throws Exception;

    // 테스트용 insert
    void insert(BookDto book) throws Exception;

    // 각 책의 지은이들을 조회
    List<String> selectWriter(Integer bookId) throws Exception;

    // 각 책의 출판사를 조회
    String selectPublisher(Integer bookId) throws Exception;

    List<BookDto> searchByAll(MainSearchCondition sc) throws Exception;

    List<BookDto> searchByTitle(MainSearchCondition sc) throws Exception;

    List<BookDto> searchByWriter(MainSearchCondition sc) throws Exception;

    int selectSearchCnt(MainSearchCondition sc) throws Exception;
}
