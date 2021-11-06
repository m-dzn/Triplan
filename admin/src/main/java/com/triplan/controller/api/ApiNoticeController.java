package com.triplan.controller.api;


import com.triplan.domain.NoticeVO;
import com.triplan.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notices")
public class ApiNoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public String noticeInsert(@RequestBody NoticeVO noticeVO){
        noticeService.noticeInsert(noticeVO);
        return "공지사항 입력 완료";
    }
    @GetMapping("/{noticeId}")
    public NoticeVO noticeSelect(@PathVariable int noticeId){
        NoticeVO noticeVO = noticeService.noticeSelect(noticeId);
        return noticeVO;
    }
    @PutMapping("/{noticeId}")
    public String noticeUpdate(@PathVariable int noticeId, @RequestBody NoticeVO noticeVO){
        noticeVO.setNoticeId(noticeId);
        noticeService.noticeUpdate(noticeVO);
        return "공지사항 수정 완료";
    }
    @DeleteMapping("/{noticeId}")
    public String noticeDelete(@PathVariable int noticeId){
        noticeService.noticeDelete(noticeId);
        return "공지사항 삭제 완료";
    }

   // @GetMapping("/notice")



}
