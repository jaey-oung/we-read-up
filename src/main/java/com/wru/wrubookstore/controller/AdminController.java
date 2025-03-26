package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.domain.PageHandler;
import com.wru.wrubookstore.dto.BookDto;
import com.wru.wrubookstore.dto.response.admin.AdminResponse;
import com.wru.wrubookstore.dto.response.book.BookListResponse;
import com.wru.wrubookstore.dto.response.category.CategoryResponse;
import com.wru.wrubookstore.service.BookService;
import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    BookService bookService;

    AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    // 업로드 경로
    private final String UPLOAD_DIR = "src/main/resources/static/img/book/";

    @PostMapping("/upload")
    @ResponseBody
    @Transactional
    public String upload(@RequestParam("image") MultipartFile formData) {
        System.out.println("file = " + formData.getOriginalFilename());
        System.out.println("formData.getResource() = " + formData.getResource());
        System.out.println("formData.getName() = " + formData.getName());
        System.out.println("formData.getSize() = " + formData.getSize());

        if(formData.isEmpty()){
            System.out.println("formData is empty");
            return "formData is empty";
        }

        try{
            String fileName = System.currentTimeMillis()+"_"+formData.getOriginalFilename();

            Path path = Paths.get(UPLOAD_DIR + fileName);

            System.out.println("path.getFileName().toString() = " + path.getFileName().toString());
            System.out.println("path.toString() = " + path.toString());

            formData.transferTo(path);

            String imagePath = "/img/book/"+fileName;
            System.out.println("imagePath = " + imagePath);

            Thread.sleep(2000);

            return imagePath;
        }catch(Exception e){
            e.printStackTrace();
            return "upload failed";
        }
    }

    @PostMapping("/bookCreate")
    @Transactional
    @ResponseBody
    public String bookCreate(@RequestBody AdminResponse adminResponse){
        System.out.println("\n\nadmin//bookCreate//adminResponse = " + adminResponse);

        return "success";
    }
    @PostMapping("/bookCategory")
    @ResponseBody
    public List<CategoryResponse> bookCategory(@RequestBody CategoryResponse[] categoryResponse, Model m){
        try{

            System.out.println("admin//categoryResponse = " + Arrays.toString(categoryResponse));
            for(CategoryResponse category : categoryResponse){
                List<CategoryResponse> list;
                if (category.getCategoryMediumId() == null) {
                    list = bookService.selectCategoryMedium(category);
                    System.out.println("\n\nadmin//Medium//List<CategoryResponse> = " + list.toString()+"\n\n");

                    return list;
                }

                list = bookService.selectCategorySmall(category);
                System.out.println("\n\nadmin//Small//List<CategoryResponse> = " + list.toString()+"\n\n");

                return list;
            }

        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @GetMapping("/bookCreate")
    public String bookCategory(Model m){
        try{
            List<CategoryResponse> categoryResponse = bookService.selectCategoryLarge();

//            System.out.println("\n\nadmin//Large//categoryResponse = " + Arrays.toString(categoryResponse.toArray())+"\n\n");
            m.addAttribute("cl", categoryResponse);
        } catch(Exception e){
            e.printStackTrace();
        }

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
