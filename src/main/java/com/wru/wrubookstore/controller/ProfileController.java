package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.MemberDto;
import com.wru.wrubookstore.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    private final MemberService memberService;

    public ProfileController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/myPage/editProfile")
    public String editProfileForm(@SessionAttribute Integer userId, Model model) {
        try {
            MemberDto memberDto = memberService.select(userId);

            model.addAttribute("member", memberDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "myPage/edit-profile";
    }

    @PostMapping("/myPage/editProfile")
    public String editProfile(@Valid @ModelAttribute("member") MemberDto memberDto, BindingResult bindingResult,
                              @RequestParam String pwConfirm, Model model) {
        System.out.println("memberDto = " + memberDto);

        // 비밀번호 동일 입력 체크
        if (!pwCheck(memberDto.getPassword(), pwConfirm)) {
            bindingResult.rejectValue("password", "PasswordMismatch", "비밀번호가 다릅니다. 다시 입력해주세요.");
        }

        // 유효성 검사 체크
        if (bindingResult.hasErrors()) {
            model.addAttribute("member", memberDto);

            return "myPage/edit-profile";
        }

        try {
             memberService.editMember(memberDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/myPage";
    }

    @PostMapping("/myPage/withdraw")
    public String withdraw(@SessionAttribute Integer userId, HttpSession session) {
        try {
            // 회원 삭제
            memberService.withdraw(userId);
            //
            session.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    private boolean pwCheck(String pw1, String pw2) {
        return pw1.equals(pw2);
    }
}
