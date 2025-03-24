package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.MainSearchCondition;
import com.wru.wrubookstore.dto.BookDto;
import com.wru.wrubookstore.dto.CategoryDto;
import com.wru.wrubookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 카테고리 정보 조회
    @Override
    public CategoryDto selectCategoryInfo(String category) throws Exception {
        return bookRepository.selectCategoryInfo(category);
    }

    // 카테고리에 속한 책들의 수 조회
    @Override
    public int selectByCategoryCnt(String category) throws Exception {
        return bookRepository.selectByCategoryCnt(category);
    }

    // 카테고리에 속한 책들의 정보 조회
    @Override
    public List<CategoryDto> selectByCategory(MainSearchCondition sc) throws Exception {
        return bookRepository.selectByCategory(sc);
    }

    // 책 번호로 한 개 조회
    @Override
    public BookDto select(Integer bookId) throws Exception{
        return bookRepository.select(bookId);
    }

    // 테스트용 insert
    @Override
    public void insert(BookDto book) throws Exception{
        bookRepository.insert(book);
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
    public List<BookDto> searchByAll(MainSearchCondition sc) throws Exception {
        return bookRepository.searchByAll(sc);
    }

    // 도서 제목으로 검색
    @Override
    public List<BookDto> searchByTitle(MainSearchCondition sc) throws Exception {
        return bookRepository.searchByTitle(sc);
    }

    // 저자 이름으로 검색
    @Override
    public List<BookDto> searchByWriter(MainSearchCondition sc) throws Exception {
        return bookRepository.searchByWriter(sc);
    }

    // 검색 결과 개수 조회
    @Override
    public int selectSearchCnt(MainSearchCondition sc) throws Exception {
        return bookRepository.selectSearchCnt(sc);
    }
}
