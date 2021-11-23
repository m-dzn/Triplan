package com.triplan.controller.api;


import com.triplan.domain.cs.NoticeVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.cs.NoticeTarget;
import com.triplan.service.inf.NoticeService;
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
    public NoticeVO noticeSelect(@PathVariable Integer noticeId){
        NoticeVO noticeVO = noticeService.noticeSelect(noticeId);
        return noticeVO;
    }

    @PutMapping("/{noticeId}")
    public String noticeUpdate(@PathVariable Integer noticeId, @RequestBody NoticeVO noticeVO){
        noticeVO.setNoticeId(noticeId);
        noticeService.noticeUpdate(noticeVO);
        return "공지사항 수정 완료";
    }

    @DeleteMapping("/{noticeId}")
    public String noticeDelete(@PathVariable Integer noticeId){
        noticeService.noticeDelete(noticeId);
        return "공지사항 삭제 완료";
    }

   @GetMapping
    public Pagination<NoticeVO> noticeList(
           @RequestParam(defaultValue = "MEMBER") NoticeTarget noticeTarget, // ?target=MEMBER로 받기 (url에 대문자 사용을 지양하는 트렌드에 맞춰서)
           @RequestParam(defaultValue = "10") Integer pageSize,
           @RequestParam(defaultValue = "1") Integer currentPage
    ) {
       Pagination<NoticeVO> noticeVO = noticeService.noticeList(noticeTarget, pageSize, currentPage);
       return noticeVO;
   }

}
