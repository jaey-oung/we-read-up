package com.wru.wrubookstore.repository;


import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.BookDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository book;

    @Test
    public void select() {
        BookDto b = book.select(1);
        System.out.println("b = " + b);
        PageHandler page = new PageHandler(251, 21, 5);
        assertTrue(b.getBookId() == 1);

        System.out.println("page.toString() = " + page.toString());
//        assertTrue(!(page.isNextPage()));
//        assertTrue(page.isPrevPage());
//        assertTrue(page.getBeginPage()==21);
//        assertTrue(page.getEndPage()==26);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        Map map = new HashMap();
        map.put("offset", 1);
        map.put("limit",  5);
        map.put("category", "cs_5");

        List<BookDto> bookDto = book.selectRegList(map);
        for(BookDto bd : bookDto){
            System.out.println("bd = " + bd);
        }
    }
}