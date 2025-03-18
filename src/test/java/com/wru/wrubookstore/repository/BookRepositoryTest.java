package com.wru.wrubookstore.repository;


import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.BookDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository book;

    @Test
    @Transactional
    public void select() throws Exception {
        for (int i = 1; i < 250; i++) {
            BookDto bookDto = new BookDto("pub_1","cs_1", ""+i, "김", 1000, new BigDecimal(0.01),170,1200, new Date(), new Date(), "목차", "내용", 1111111111, 100, "133*200", 420, 300,"https://image.aladin.co.kr/product/32875/63/cover500/k562936112_2.jpg");
            book.insert(bookDto);
        }


    }
}