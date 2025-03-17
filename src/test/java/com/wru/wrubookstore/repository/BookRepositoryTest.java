package com.wru.wrubookstore.repository;


import com.wru.wrubookstore.dto.BookDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository book;

    @Test
    public void select() {
        BookDto b = book.select(1);
        System.out.println("b = " + b);
        assertTrue(b.getBookId() == 1);
    }
}