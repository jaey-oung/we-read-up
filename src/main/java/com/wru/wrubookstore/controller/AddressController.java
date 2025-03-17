package com.wru.wrubookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {

    @GetMapping("/myPage/addressList")
    public String addressList() {

        return "myPage/address-list";
    }

    @GetMapping("/myPage/addAddress")
    public String addAddressForm() {

        return "myPage/add-address";
    }

    @PostMapping("/myPage/addAddress")
    public String addAddress() {

        return "redirect:/myPage/addressList";
    }
}
