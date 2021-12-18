package com.triplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerPageController {

    @GetMapping
    public String home() {
        return "seller/index";
    }

    @GetMapping("item-management")
    public String itemManagement() {
        return "seller/page/itemManagement";
    }

    @GetMapping("item-group-register")
    public String itemGroupRegister() {
        return "seller/page/itemGroupRegister";
    }

    @GetMapping("question-management")
    public String questionManagement() {
        return "seller/page/questionManagement";
    }

    @GetMapping("question-answer")
    public String questionAnswer() {
        return "seller/page/questionAnswer";
    }

    @GetMapping("reservation-management")
    public String reservationManagement() {
        return "seller/page/reservationManagement";
    }

}
