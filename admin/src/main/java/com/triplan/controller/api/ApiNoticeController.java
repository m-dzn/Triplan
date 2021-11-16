package com.triplan.controller.api;


import com.triplan.domain.NoticeVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.Target;
import com.triplan.service.NoticeService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notices")
public class ApiNoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public String noticeInsert(@Valid @RequestBody NoticeVO noticeVO){
        noticeService.noticeInsert(noticeVO);
        return "공지사항 입력 완료";
    }
    @GetMapping("/{noticeId}")
    public NoticeVO noticeSelect(@PathVariable Integer noticeId){
        NoticeVO noticeVO = noticeService.noticeSelect(noticeId);
        return noticeVO;
    }
    @PutMapping("/{noticeId}")
    public String noticeUpdate(@PathVariable Integer noticeId, @Valid @RequestBody NoticeVO noticeVO){
        noticeVO.setNoticeId(noticeId);
        noticeService.noticeUpdate(noticeVO);
        return "공지사항 수정 완료";
    }
    @DeleteMapping("/{noticeId}")
    public String noticeDelete(@PathVariable Integer noticeId){
        noticeService.noticeDelete(noticeId);
        return "공지사항 삭제 완료";
    }

   // 모든 리스트
    @GetMapping("/list")
    public Pagination<NoticeVO> noticeAllList(

            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage)
    {
        return noticeService.noticeAllList(pageSize, currentPage);
    }

    // 타겟별 리스트 - SELLER
   @GetMapping("/list/seller")
    public Pagination<NoticeVO> noticeSellerList(

            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage) {
      /* Pagination<NoticeVO> noticeVO = noticeService.noticeList(target,pageSize,currentPage);
       return noticeVO;*/
       return noticeService.noticeSellerList(Target.SELLER,pageSize,currentPage);
   }
    // 타겟별 리스트 - MEMBER
    @GetMapping("/list/member")
    public Pagination<NoticeVO> noticeMemberList(

            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage) {
      /* Pagination<NoticeVO> noticeVO = noticeService.noticeList(target,pageSize,currentPage);
       return noticeVO;*/
        return noticeService.noticeSellerList(Target.MEMBER,pageSize,currentPage);
    }






}
