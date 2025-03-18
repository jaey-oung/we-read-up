package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.BookDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final SqlSessionTemplate session;
    private final String namespace = "com.wru.wrubookstore.mapper.BookMapper.";

    public BookRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    // 책 번호로 한개 조회
    @Override
    public BookDto select(Integer bookId) throws Exception{
        return session.selectOne(namespace + "select", bookId);
    }
    // LIMIT로 N개 조회 category(카테고리 소), offset, limit
    @Override
    public List<BookDto> selectRegList(Map map) throws Exception{ return session.selectList(namespace + "selectRegList", map);}
    // 카테고리에 있는 책 수 조회
    @Override
    public int sCategoryCnt(String category) throws Exception{ return session.selectOne(namespace + "sCategoryCnt", category);}
    // 테스트용 insert
    @Override
    public void insert(BookDto book)  throws Exception{
        session.insert(namespace + "insert", book);
    }
}
