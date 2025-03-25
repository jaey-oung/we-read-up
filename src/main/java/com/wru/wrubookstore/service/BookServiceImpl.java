package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.MainSearchCondition;
import com.wru.wrubookstore.dto.BookDto;
import com.wru.wrubookstore.dto.response.book.BookListResponse;
import com.wru.wrubookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public int countAllByAdmin() throws Exception {
        return bookRepository.countAllByAdmin();
    }

    @Override
    public List<BookDto> selectAllByAdmin() throws Exception {
        return bookRepository.selectAllByAdmin();
    }

    @Override
    public void deleteAllByAdmin() throws Exception {
        bookRepository.deleteAllByAdmin();
    }

    @Override
    public void updateByAdmin(BookListResponse bookListResponse) throws Exception {
        bookRepository.updateByAdmin(bookListResponse);
    }

    @Override
    public void deleteByAdmin(BookListResponse bookListResponse) throws Exception{
        bookRepository.deleteByAdmin(bookListResponse);
    }

    @Override
    public int countQuantityZeroByAdmin() throws Exception{
        return bookRepository.countQuantityZeroByAdmin();
    }

    @Override
    public List<BookDto> selectBook(Map map) throws Exception{
        return bookRepository.selectBook(map);
    }

    // 책 번호로 한개 조회
    @Override
    public BookDto select(Integer bookId) throws Exception{
        return bookRepository.select(bookId);
    }
    // LIMIT로 N개 조회 category(카테고리 소), offset, limit
    @Override
    public List<BookDto> selectRegList(Map map) throws Exception{
        return bookRepository.selectRegList(map);
    }
    // 카테고리에 있는 책 수 조회
    @Override
    public int sCategoryCnt(String category) throws Exception{
        return bookRepository.sCategoryCnt(category);
    }
    // 테스트용 insert
    @Override
    public int insert(BookDto book) throws Exception{
        return bookRepository.insert(book);
    }
    // 각 책의 지은이들을 조회
    @Override
    public List<String> selectWriter(Integer bookId) throws Exception{
        return bookRepository.selectWriter(bookId);
    }
    // 각 책의 출판사를 조회
    @Override
    public String selectPublisher(Integer bookId) throws Exception{
        return bookRepository.selectPublisher(bookId);
    }

    //  도서 제목과 저자 이름으로 통합 검색
    @Override
    public List<BookDto> selectByAll(MainSearchCondition sc) throws Exception {
        return bookRepository.searchByAll(sc);
    }

    // 도서 제목으로 검색
    @Override
    public List<BookDto> selectByTitle(MainSearchCondition sc) throws Exception {
        return bookRepository.searchByTitle(sc);
    }

    // 저자 이름으로 검색
    @Override
    public List<BookDto> selectByWriter(MainSearchCondition sc) throws Exception {
        return bookRepository.searchByWriter(sc);
    }

    // 검색 결과 개수 조회
    @Override
    public int selectSearchCnt(MainSearchCondition sc) throws Exception {
        return bookRepository.selectSearchCnt(sc);
    }

}
