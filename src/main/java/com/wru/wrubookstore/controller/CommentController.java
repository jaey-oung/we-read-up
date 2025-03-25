package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.CommentDto;
import com.wru.wrubookstore.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class CommentController {

    @Autowired
    CommentService service;

    //    {
//            "comment" : "hihihi",
//            "memberId" : 1
//    }

    // 댓글을 수정하는 메서드
    @PatchMapping("/comments/{commentId}")   // /ch4/comments/26  PATCH
    public ResponseEntity<String> modify(@PathVariable Integer commentId, @RequestBody CommentDto dto, HttpSession session) {
//        String commenter = (String)session.getAttribute("id");
        Integer memberId = 1;
        dto.setMemberId(memberId);
        dto.setCommentId(commentId);
        System.out.println("dto = " + dto);

        try {
            if(service.modify(dto)!=1)
                throw new Exception("Write failed.");

            return new ResponseEntity<>("MOD_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("MOD_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    //    {
//        "pcno":0,
//            "comment" : "hi"
//    }
    // 댓글을 등록하는 메서드
    @PostMapping("/comments")   // /ch4/comments?noticeId=1  POST
    public ResponseEntity<String> write(@RequestBody CommentDto dto, Integer noticeId, HttpSession session) {
//        String commenter = (String)session.getAttribute("id");
        Integer memberId = 1;
        dto.setMemberId(memberId);
        dto.setNoticeId(noticeId);
        System.out.println("dto = " + dto);

        try {
            if(service.write(dto)!=1)
                throw new Exception("Write failed.");

            return new ResponseEntity<>("WRT_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("WRT_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    // 지정된 댓글을 삭제하는 메서드
    @DeleteMapping("/comments/{commentId}")  // DELETE /comments/9?noticeId=1  <-- 삭제할 댓글 번호
    public ResponseEntity<String> remove(@PathVariable Integer commentId,@RequestParam Integer noticeId, HttpSession session) {
//        String commenter = (String)session.getAttribute("id");
        Integer memeberId = 1;

        try {
            int rowCnt = service.remove(commentId, noticeId, memeberId);
            System.out.println("commentId = " + commentId);
            System.out.println("noticeId = " + noticeId);

            if(rowCnt!=1)
                throw new Exception("Delete Failed");

            return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    // 지정된 게시물의 모든 댓글을 가져오는 메서드
    @GetMapping("/comments")  // /comments?noticeId=1   GET
    public ResponseEntity<List<CommentDto>> list(Integer noticeId) {
        List<CommentDto> list = null;
        try {
            list = service.getList(noticeId);
            System.out.println("commentlist = " + list);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);  // 200
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST); // 400
        }
    }

}
