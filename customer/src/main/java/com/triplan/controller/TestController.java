package com.triplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 매핑시켜 줄 주소 이름
public class TestController {

    @GetMapping("/pay")
    public String pay(){

        return "pay"; // 매핑시켜 줄 html파일 -> @RequestMapping에 입력된 주소를 입력하면 연결 될 파일
    }

    @GetMapping("/member_withdraw")
    public String member_withdraw(){

        return "member_withdraw"; // 매핑시켜 줄 html파일 -> @RequestMapping에 입력된 주소를 입력하면 연결 될 파일
    }


}