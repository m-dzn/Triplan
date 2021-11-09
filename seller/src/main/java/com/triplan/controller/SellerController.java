package com.triplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @GetMapping("item-management")
    public String itemManagement() {
        return "/page/itemManagement";
    }

    @GetMapping("item-group-register")
    public String itemGroupRegister() {
        return "/page/itemGroupRegister";
    }

    @GetMapping("question-management")
    public String questionManagement() {
        return "/page/questionManagement";
    }

    @GetMapping("question-answer")
    public String questionAnswer() {
        return "/page/questionAnswer";
    }

    @GetMapping("reservation-management")
    public String reservationManagement() {
        return "/page/reservationManagement";
    }

}
