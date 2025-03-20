package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.ReviewDto;
import com.wru.wrubookstore.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewController {
    ReviewService reviewService;

    ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviewList")
    public String reviewList() {

        return "board/review-list";
    }

    @GetMapping("/reviewDetail")
    public String reviewDetail() {

        return "board/review-detail";
    }

    @PostMapping("/reviewInsert")
    @ResponseBody
    public String reviewInsert(@RequestBody ReviewDto reviewDto){

        System.out.println("reviewDto = " + reviewDto);
        try{
            // 내용이 없거나, 별점을 안눌렀으면 에러
            if (reviewDto.getContent().isEmpty() || reviewDto.getRating() == null) {
                throw new Exception("등록 실패");
            }
            reviewService.insertReview(reviewDto);

            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "error";
        }

    }
}
