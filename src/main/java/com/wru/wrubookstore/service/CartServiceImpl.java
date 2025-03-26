package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.CartDto;
import com.wru.wrubookstore.dto.response.cart.CartListResponse;
import com.wru.wrubookstore.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public int countAllByAdmin() throws Exception {
        return cartRepository.countAllByAdmin();
    }

    @Override
    public List<CartDto> selectAllByAdmin() throws Exception {
        return cartRepository.selectAllByAdmin();
    }

    @Override
    public void deleteAllByAdmin() throws Exception {
        cartRepository.deleteAllByAdmin();
    }

    @Override
    public int countAllByUserId(int userId) throws Exception {
        return cartRepository.countAllByUserId(userId);
    }

    @Override
    public List<CartDto> selectAllByUserId(int userId) throws Exception {
        return cartRepository.selectAllByUserId(userId);
    }

    @Override
    public List<CartListResponse> selectCartListByUserId(int userId) throws Exception {
        return cartRepository.selectCartListByUserId(userId);
    }

    @Override
    public CartListResponse selectCartByCartId(int cartId) throws Exception {
        return cartRepository.selectCartByCartId(cartId);
    }

    @Override
    public CartDto selectByUserIdAndBookId(int userId, int bookId) throws Exception {
        return cartRepository.selectByUserIdAndBookId(userId, bookId);
    }

    @Override
    public String insert(CartDto cartDto) throws Exception {
        CartDto existing = cartRepository.selectByUserIdAndBookId(cartDto.getUserId(), cartDto.getBookId());
        if (existing != null)
            return "이미 장바구니에 담긴 도서입니다";

        int rowCnt = cartRepository.insert(cartDto);
        return rowCnt == 1 ? "도서를 장바구니에 추가했습니다" : "장바구니 추가에 실패했습니다";
    }

    @Override
    public int update(CartDto cartDto) throws Exception {
        return cartRepository.update(cartDto);
    }

    @Override
    public int delete(int cartId) throws Exception {
        return cartRepository.delete(cartId);
    }

}
