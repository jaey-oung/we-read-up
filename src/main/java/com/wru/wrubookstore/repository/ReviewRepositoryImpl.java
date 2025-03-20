package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.ReviewDto;
import com.wru.wrubookstore.dto.response.review.ReviewListResponse;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
    SqlSessionTemplate session;

    ReviewRepositoryImpl(SqlSessionTemplate session) {
        this.session = session;
    }

    String namespace = "com.wru.wrubookstore.mapper.reviewMapper.";

    // 해당 책의 등록된 리뷰의 수 조회
    @Override
    public int countReview(Integer bookId) throws Exception{
        return session.selectOne(namespace + "countReview", bookId);
    }

    // 해당 책의 등록된 리뷰를 전부 조회 (오래된 순)
    @Override
    public List<ReviewListResponse> selectReview(Integer bookId) throws Exception{
        return session.selectList(namespace + "selectReview", bookId);
    }

    // 해당 책에 리뷰 추가
    @Override
    public void insertReview(ReviewDto reviewDto) throws Exception{
        session.insert(namespace + "insertReview", reviewDto);
    }

    // 해당 책에 리뷰 삭제
    @Override
    public void deleteReview(Map map) throws Exception{
        session.delete(namespace + "deleteReview", map);
    }

    // 해당 책에 리뷰 수정
    @Override
    public void modifyReview(Map map) throws Exception{
        session.update(namespace + "modifyReview", map);
    }

}
