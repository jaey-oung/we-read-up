package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.domain.MainSearchCondition;
import com.wru.wrubookstore.domain.SearchCondition;
import com.wru.wrubookstore.dto.*;
import com.wru.wrubookstore.dto.response.review.ReviewListResponse;
import com.wru.wrubookstore.service.BookService;
import com.wru.wrubookstore.service.LikeService;
import com.wru.wrubookstore.service.MemberService;
import com.wru.wrubookstore.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    private final BookService bookService;
    private final LikeService likeService;
    private final ReviewService reviewService;
    private final MemberService memberService;

    BookController(BookService bookService, LikeService likeService, ReviewService reviewService, MemberService memberService) {
        this.bookService = bookService;
        this.likeService = likeService;
        this.reviewService = reviewService;
        this.memberService = memberService;
    }

    @GetMapping("/bookList")
    public String bookList(MainSearchCondition sc, Model model, HttpServletRequest request,
                           HttpSession session) {

//        int userId = (int) session.getAttribute("userId");

        try{
            int count = bookService.selectByCategoryCnt(sc.getCategory());
            List<CategoryDto> list = new ArrayList<>();
            if (count == 0) {
                CategoryDto categoryInfo = bookService.selectCategoryInfo(sc.getCategory());
                model.addAttribute("category", categoryInfo);
            } else if (count > 0) {
                list = bookService.selectByCategory(sc);
            } else {
                throw new Exception("잘못된 도서 개수입니다.");
            }

            PageHandler pageHandler = new PageHandler(count, sc.getPage(), sc.getPageSize());

            model.addAttribute("sc", sc);
//            model.addAttribute("userId", userId);
            model.addAttribute("list", list);
            model.addAttribute("ph", pageHandler);
            model.addAttribute("uri", request.getRequestURI());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return "book/book-list";
    }

    @GetMapping("/search")
    public String search(MainSearchCondition sc, Model model, HttpServletRequest request) {

        try {
            String option = sc.getOption();
            int count = bookService.selectSearchCnt(sc);
            List<BookDto> list = switch (option) {
                case "all" -> bookService.searchByAll(sc);
                case "title" ->  bookService.searchByTitle(sc);
                case "writer" -> bookService.searchByWriter(sc);
                default -> throw new Exception("잘못된 옵션입니다.");
            };

            PageHandler pageHandler = new PageHandler(count, sc.getPage(), sc.getPageSize());
            model.addAttribute("sc", sc);
            model.addAttribute("list", list);
            model.addAttribute("ph", pageHandler);
            model.addAttribute("uri", request.getRequestURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "book/book-list";
    }


    @GetMapping("/bookDetail")
    public String bookDetail(HttpSession session, Integer bookId, Integer page, String category, Integer pageSize, Model m) {

        try{
            int userId = 0;

            // 멤버 정보 조회
            if((Boolean)session.getAttribute("isMember")){
                userId = (Integer)session.getAttribute("userId");
                System.out.println("userId = " + userId);
            }

            MemberDto memberDto = memberService.selectMember(userId);
            System.out.println("memberDto = " + memberDto);

            int memberId = memberDto.getMemberId();
            // 좋아요 누른 회원의 정보 조회
            LikeDto likeDto = new LikeDto(bookId, memberId);
            // 책 정보 조회
            BookDto bookDto = bookService.select(bookId);
            // 지은이들 조회
            List<String> writer = bookService.selectWriter(bookId);
            // 출판사 조회
            String publisher = bookService.selectPublisher(bookId);
            // 리뷰들 조회
            List<ReviewListResponse> review = reviewService.selectReview(bookId);
            // 0이면 좋아요 안누른 유저, 1이면 좋아요 누른 유저
            int isLikeUser = likeService.selectLikeMember(likeDto);
            // 리뷰가 있는지 없는지 확인
            int reviewCnt = reviewService.countReview(bookId);



            m.addAttribute("memberId", memberId);
            m.addAttribute("review", review);
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
