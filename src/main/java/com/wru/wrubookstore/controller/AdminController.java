package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.BookDto;
import com.wru.wrubookstore.dto.response.book.BookListResponse;
import com.wru.wrubookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    BookService bookService;

    AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookCreate")
    public String bookCreate(){
        return "admin/admin-book-create";
    }

    @PostMapping("/bookDelete")
    @ResponseBody
    public String bookDelete(@RequestBody BookListResponse[] bookListResponse){
        try{
            System.out.println("admin//Arrays.toString(bookId) = " + Arrays.toString(bookListResponse));

            if(bookListResponse==null || bookListResponse.length==0){
                throw new Exception("No Such Element");
            }

            for(BookListResponse list : bookListResponse){
                bookService.deleteByAdmin(list);
            }


        }catch(Exception e){
            e.printStackTrace();
            return "fail";

        }
        return "success";
    }

    @PostMapping("/bookMod")
    @ResponseBody
    public String bookMod(@RequestBody BookListResponse[] bookListResponse, Integer page, Model m){
        try{
            System.out.println("admin//bookListResponse = " + Arrays.toString(bookListResponse));
            // 넘어온 정보가 없다면 에러
            if(bookListResponse == null || bookListResponse.length == 0){
                throw new Exception("No Such Element");
            }

            for(BookListResponse list : bookListResponse){
                bookService.updateByAdmin(list);
            }


        } catch(Exception e){
            e.printStackTrace();
            return "fail";
        }

        return "success";
    }

    @GetMapping("/bookList")
    public String bookList(Model m, Integer page, Integer pageSize){
        try{
            if(page == null || page < 1){
                page = 1;
            }
            if(pageSize == null || pageSize < 1){
                pageSize = 5;
            }

            // 관리자용 등록된 상품 갯수
            int countAllByAdmin = bookService.countAllByAdmin();
            m.addAttribute("countAllByAdmin", countAllByAdmin);

            int countQuantityZeroByAdmin = bookService.countQuantityZeroByAdmin();
            m.addAttribute("countQuantityZeroByAdmin", countQuantityZeroByAdmin);

            // 페이징
            PageHandler pageHandler = new PageHandler(countAllByAdmin, page, pageSize);
            m.addAttribute("ph", pageHandler);

            // 상품 정보
            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("limit", pageSize);

            List<BookDto> bookDto = bookService.selectBook(map);

            // 상품 정보
            m.addAttribute("bookDto", bookDto);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/admin-book-list";
    }

}
