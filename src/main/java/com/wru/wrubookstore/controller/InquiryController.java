package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.InquiryDto;
import com.wru.wrubookstore.service.InquiryServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/inquiryboard")
public class InquiryController {

    private final InquiryServiceImpl inquiryService;

    public InquiryController(InquiryServiceImpl inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/list")
    public String list(Model m, HttpSession session){
//        Integer memberId = (Integer) session.getAttribute("id");
        Integer memberId = 2;

        try {
            List<InquiryDto> list = inquiryService.getList(memberId);

//            System.out.println("memberId = " + memberId);
//            System.out.println("list = " + list);

            m.addAttribute("list", list);
            m.addAttribute("mode", "read");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board/inquiry-list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("inquiryId") Integer inquiryId, HttpSession session, RedirectAttributes rdatt) {
//        Integer memberId = (Integer) session.getAttribute("id");
        Integer memberId = 2;

        try {
            int rowCnt = inquiryService.remove(inquiryId, memberId);
            if(rowCnt!=1)
                throw new Exception("inquiry remove error");
            rdatt.addFlashAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rdatt.addFlashAttribute("msg", "DEL_ERR");
        }
        return "redirect:/inquiryboard/list";
    }

    @GetMapping("/write")
    public String writer(Model m){
        m.addAttribute("mode","new");
        return "board/inquiry-list";         //읽기와 쓰기에 사용, 쓰기에 사용할때는 mode=new
    }

    @PostMapping("/write")
    public String write(@RequestBody InquiryDto inquiryDto, Model m, HttpSession session, RedirectAttributes rdatt){
        //        Integer memberId = (Integer) session.getAttribute("id");
        Integer memberId = 2;
        inquiryDto.setMemberId(memberId);
        inquiryDto.setEmployeeId("emp_4");
        inquiryDto.setInquiryStatusId("inq_1");

        System.out.println("inquiryDto = " + inquiryDto);

        try {
            int rowCnt = inquiryService.write(inquiryDto);
            if(rowCnt!=1)
                throw new Exception("Write failed");
            rdatt.addFlashAttribute("msg", "WRT_OK");
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("inquiryDto", inquiryDto);
            rdatt.addFlashAttribute("msg", "WRT_ERR");
        }
        return "board/inquiry-list";
    }

    @PostMapping("/modify")
    public String modify(@RequestBody InquiryDto inquiryDto, Model m, HttpSession session, RedirectAttributes rdatt){
        //        String employeeId = (String) session.getAttribute("id");
        String employeeId = "emp_4";

        inquiryDto.setEmployeeId(employeeId);

        try {
            int rowCnt = inquiryService.modify(inquiryDto);

            if(rowCnt!=1)
                throw new Exception("Modify failed");
            rdatt.addFlashAttribute("msg","MOD_OK");
            return "redirect:/board/inquiry-list";
        } catch (Exception e) {
            e.printStackTrace();
            rdatt.addFlashAttribute("msg","MOD_ERR");
        }
        return "board/inquiry-list";
    }
}
