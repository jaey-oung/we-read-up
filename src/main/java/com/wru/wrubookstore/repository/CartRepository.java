package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.CartDto;

import java.util.List;

public interface CartRepository {

    // 관리자용
    int countAllByAdmin() throws Exception;
    List<CartDto> selectAllByAdmin() throws Exception;
    void deleteAllByAdmin() throws Exception;

    // 사용자용
    int countAllByUserId(int userId) throws Exception;
    List<CartDto> selectAllByUserId(int userId) throws Exception;
    CartDto selectByUserIdAndBookId(int userId, int bookId) throws Exception;
    int insert(CartDto cartDto) throws Exception;
    int update(CartDto cartDto) throws Exception;
    int delete(int cartId) throws Exception;

}
