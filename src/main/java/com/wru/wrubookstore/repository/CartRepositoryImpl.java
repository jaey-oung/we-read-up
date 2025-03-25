package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.CartDto;
import com.wru.wrubookstore.dto.response.cart.CartListResponse;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository {

    private final String namespace = "com.wru.wrubookstore.mapper.CartMapper.";
    private final SqlSessionTemplate session;

    public CartRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    @Override
    public int countAllByAdmin() throws Exception {
        return session.selectOne(namespace + "countAllByAdmin");
    }

    @Override
    public List<CartDto> selectAllByAdmin() throws Exception {
        return session.selectList(namespace + "selectAllByAdmin");
    }

    @Override
    public void deleteAllByAdmin() throws Exception {
        session.delete(namespace + "deleteAllByAdmin");
    }

    @Override
    public int countAllByUserId(int userId) throws Exception {
        return session.selectOne(namespace + "countAllByUserId", userId);
    }

    @Override
    public List<CartDto> selectAllByUserId(int userId) throws Exception {
        return session.selectList(namespace + "selectAllByUserId", userId);
    }

    @Override
    public List<CartListResponse> selectCartListByUserId(int userId) throws Exception {
        return session.selectList(namespace + "selectCartListByUserId", userId);
    }

    @Override
    public CartListResponse selectCartByCartId(int cartId) throws Exception {
        return session.selectOne(namespace + "selectCartByCartId", cartId);
    }

    @Override
    public CartDto selectByUserIdAndBookId(int userId, int bookId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("bookId", bookId);
        return session.selectOne(namespace + "selectByUserIdAndBookId", map);
    }

    @Override
    public int insert(CartDto cartDto) throws Exception {
        return session.insert(namespace + "insert", cartDto);
    }

    @Override
    public int update(CartDto cartDto) throws Exception {
        return session.update(namespace + "update", cartDto);
    }

    @Override
    public int delete(int cartId) throws Exception {
        return session.delete(namespace + "delete", cartId);
    }

}
