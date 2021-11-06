package com.triplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @GetMapping
    public String noticePage() {
        return "notice";
    }

    @GetMapping("/content")
    public String noticeContent() { return "notice_content"; }

    @GetMapping("/update")
    public String noticeUpdate() { return  "notice_update"; }

    @GetMapping("/write")
    public String noticeWrite() { return "notice_write"; }


}
