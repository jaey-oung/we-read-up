package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.BookDto;
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
}
