package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.domain.MainSearchCondition;
import com.wru.wrubookstore.dto.BookDto;
import com.wru.wrubookstore.dto.LikeDto;
import com.wru.wrubookstore.dto.ReviewDto;
import com.wru.wrubookstore.dto.response.review.ReviewListResponse;
import com.wru.wrubookstore.service.BookService;
import com.wru.wrubookstore.service.LikeService;
import com.wru.wrubookstore.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    private final BookService bookService;
    private final LikeService likeService;
    private final ReviewService reviewService;

    BookController(BookService bookService, LikeService likeService, ReviewService reviewService) {
        this.bookService = bookService;
        this.likeService = likeService;
        this.reviewService = reviewService;
    }

    @GetMapping("/searchCategory")
    public String bookList(Integer page, String category, Integer pageSize,Model m) {
        // 홈페이지에서 카테고리를 눌러서 들어온다.
        // 카테고리 id가 넘어오고
        // 카테고리 id로 해당 카테고리의 bookList를 보여준다.

        // 1. 페이징
        // page가 null 이면 기본값추가
        if(page==null)
            page=1;
        // viewBookCnt가 null 이면 기본값추가
        if(pageSize==null || pageSize==10)
            pageSize=8;
        // category가 null 이면 기본값추가
        if(category==null)
            category="cs_2";

        try{
            // 카테고리 id에 있는 책의 수를 가져온다.
            int bookCnt = bookService.sCategoryCnt(category);
            // 페이지 만듬
            PageHandler pageHandler = new PageHandler(bookCnt, page, pageSize);

            // 2. 책 정보 날려주기
            // Map에 category, offset, limit를 put
            Map map = new HashMap();
            // PageHandler로 넘겨주기
            map.put("category", category);
            // 0-8-16-24
            map.put("offset", (page-1)*pageSize);
            // pageSize 만큼 뽑기
            map.put("limit", pageSize);
            List<BookDto> list = bookService.selectRegList(map);

            // 3. Model 에 담아서 view 로 넘기기
            m.addAttribute("ph", pageHandler);
            m.addAttribute("list", list);
            m.addAttribute("category", category);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return "book/book-list";
    }

    @GetMapping("/bookList")
    public String bookList(MainSearchCondition sc, Model model) {

        try {
            String option = sc.getOption();
            int count = bookService.selectSearchCnt(sc);
            List<BookDto> list = switch (option) {
                case "all" -> bookService.selectByAll(sc);
                case "title" ->  bookService.selectByTitle(sc);
                case "writer" -> bookService.selectByWriter(sc);
                default -> throw new Exception("잘못된 옵션입니다.");
            };

            PageHandler pageHandler = new PageHandler(count, sc.getPage(), sc.getPageSize());
            model.addAttribute("sc", sc);
            model.addAttribute("list", list);
            model.addAttribute("ph", pageHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "book/book-list";
    }


    @GetMapping("/bookDetail")
    public String bookDetail(Integer bookId, Integer page, String category, Integer pageSize,Model m) {

        try{
            // String id = (String)session.getAttribute("userId");
            // User - email로 교체 예정
//          String id = "gildong@naver.com";

            LikeDto likeDto = new LikeDto(bookId, 1);

            // 책 정보 조회
            BookDto bookDto = bookService.select(bookId);
            // 지은이들 조회
            List<String> writer = bookService.selectWriter(bookId);
            // 출판사 조회
            String publisher = bookService.selectPublisher(bookId);

            // 0이면 좋아요 안누른 유저, 1이면 좋아요 누른 유저
            int isLikeUser = likeService.selectLikeMember(likeDto);
            // 리뷰가 있는지 없는지 확인
            int reviewCnt = reviewService.countReview(bookId);

            // 리뷰가 있으면 리뷰 조회
            if(reviewCnt!=0){
                // 리뷰들 조회
                List<ReviewListResponse> review = reviewService.selectReview(bookId);
                m.addAttribute("review", review);
            }

            m.addAttribute("bookDto", bookDto);
            m.addAttribute("writer", writer);
            m.addAttribute("publisher", publisher);
            m.addAttribute("isLikeUser", isLikeUser);
            m.addAttribute("reviewCnt", reviewCnt);

            System.out.println("isLikeUser = " + isLikeUser);
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        } catch(Exception e){
            e.printStackTrace();
        }


        return "book/book-detail";
    }
}
