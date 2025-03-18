package com.wru.wrubookstore.controller;

import com.wru.wrubookstore.dto.AddressDto;
import com.wru.wrubookstore.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/myPage/addressList")
    public String addressList(Model model) {
        // 임의의 회원 값 입력(수정 필요)
        try {
            List<AddressDto> addressDtoList = addressService.selectList(1);

            model.addAttribute("addressList", addressDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "myPage/address-list";
    }

    @GetMapping("/myPage/addAddress")
    public String addAddressForm() {

        return "myPage/add-address";
    }

    @PostMapping("/myPage/addAddress")
    public String addAddress(@ModelAttribute AddressDto addressDto) {
        // 임의의 회원 값 입력(수정 필요)
        addressDto.setMemberId(1);

        try {
            addressService.insert(addressDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/myPage/addressList";
    }
}
