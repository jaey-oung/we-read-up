package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.LikeDto;
import com.wru.wrubookstore.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LikeServiceImpl implements LikeService {
    LikeRepository likeRepository;

    LikeServiceImpl(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    // 해당 책의 좋아요 수 조회
    @Override
    public Integer likeCount(Integer bookId) throws Exception{
        return likeRepository.likeCount(bookId);
    }

    // 현재 유저가 해당 책을 좋아요 눌렀는지 확인
    @Override
    public Integer selectLikeMember(LikeDto likeDto) throws Exception{
        return likeRepository.selectLikeMember(likeDto);
    }
    // 해당 책을 좋아요에 추가
    @Override
    public void insertLike(LikeDto likeDto) throws Exception{
        likeRepository.insertLike(likeDto);
    }
    // 해당 책에 누른 좋아요 삭제
    @Override
    public void deleteLike(LikeDto likeDto) throws Exception{
        likeRepository.deleteLike(likeDto);
    }
}
