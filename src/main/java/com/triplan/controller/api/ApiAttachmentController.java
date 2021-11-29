package com.triplan.controller.api;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.service.inf.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attachments")
public class ApiAttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping("/insert") // 파일업로드
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String save(@RequestBody List<MultipartFile> files,
                       @RequestParam("aboutTableType") AboutTableType aboutTableType,
                       @RequestParam("idInTableType") Integer idInTableType
                       ) {
//        attachmentService.save(files, aboutTableType, idInTableType);
        attachmentService.save(files, aboutTableType, idInTableType); // 테스트 데이터
        return "첨부파일 create 완료";
    }

    @GetMapping("/read") // 파일목록
    public List<AttachmentVO> getList(
            @RequestParam("aboutTableType") AboutTableType aboutTableType,
            @RequestParam("idInTableType") Integer idInTableType
    ) {

//        attachmentService.getlist(aboutTableType, idInTableType);
        return attachmentService.getList(aboutTableType, idInTableType); // 테스트 데이터
    }

    @DeleteMapping("/remove") // 파일삭제
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String remove(@RequestBody List<Integer> attachmentIdList) {
        attachmentService.remove(attachmentIdList);
        return "첨부파일 delete 완료";
    }

    @DeleteMapping("/{aboutTableType}/{idInTableType}") // 파일삭제
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String removeByTableId(
            @PathVariable AboutTableType aboutTableType,
            @PathVariable Integer idInTableType
    ) {
        attachmentService.removeByTableId(aboutTableType, idInTableType);
        return "첨부파일 delete 완료";
    }

}