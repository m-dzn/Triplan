package com.triplan.controller;


import com.triplan.domain.NoticeVO;
import com.triplan.enumclass.Target;
import com.triplan.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

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
