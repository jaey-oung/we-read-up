package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.domain.MainSearchCondition;
import com.wru.wrubookstore.dto.BookDto;
import com.wru.wrubookstore.dto.response.book.BookListResponse;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final SqlSessionTemplate session;

    public BookRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    private final String namespace = "com.wru.wrubookstore.mapper.BookMapper.";

    // 관리자용
    @Override
    public int countAllByAdmin() throws Exception {
        return session.selectOne(namespace + "countAllByAdmin");
    }

    @Override
    public List<BookDto> selectAllByAdmin() throws Exception {
        return session.selectList(namespace + "selectAllByAdmin");
    }

    @Override
    public void deleteAllByAdmin() throws Exception {
        session.delete(namespace + "deleteAllByAdmin");
    }

    @Override
    public void updateByAdmin(BookListResponse bookListResponse) throws Exception {
        session.update(namespace + "updateByAdmin", bookListResponse);
    }

    @Override
    public int countQuantityZeroByAdmin() throws Exception{
        return session.selectOne(namespace + "countQuantityZeroByAdmin");
    }

    @Override
    public List<BookDto> selectBook(Map map) throws Exception{
        return session.selectList(namespace + "selectBook", map);
    }

    @Override
    public void deleteByAdmin(BookListResponse bookListResponse) throws Exception{
        session.delete(namespace + "deleteByAdmin", bookListResponse);
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
    public int insert(BookDto book)  throws Exception{
        return session.insert(namespace + "insert", book);
    }
    // 각 책의 지은이들을 조회
    @Override
    public List<String> selectWriter(Integer bookId) throws Exception{
        return session.selectList(namespace + "selectWriter", bookId);
    }
    // 각 책의 출판사를 조회
    @Override
    public String selectPublisher(Integer bookId) throws Exception{
        return session.selectOne(namespace + "selectPublisher", bookId);
    }

    //  도서 제목과 저자 이름으로 통합 검색
    public List<BookDto> searchByAll(MainSearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchByAll", sc);
    }

    // 도서 제목으로 검색
    public List<BookDto> searchByTitle(MainSearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchByTitle", sc);
    }

    // 저자 이름으로 검색
    public List<BookDto> searchByWriter(MainSearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchByWriter", sc);
    }

    // 검색 결과 개수 조회
    @Override
    public int selectSearchCnt(MainSearchCondition sc) throws Exception {
        return session.selectOne(namespace + "selectSearchCnt", sc);
    }

}
