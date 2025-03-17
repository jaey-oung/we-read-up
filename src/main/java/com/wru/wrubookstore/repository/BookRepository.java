package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.BookDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final SqlSessionTemplate session;
    private final String namespace = "hello.board.board.mapper.BookMapper.";

    public BookRepository(SqlSessionTemplate session) {
        this.session = session;
    }

    public BookDto select(int book_id) {
        return session.selectOne(namespace + "select", book_id);
    }
}
