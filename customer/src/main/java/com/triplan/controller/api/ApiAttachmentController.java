package com.triplan.controller.api;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.service.inf.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attachments")
public class ApiAttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping // 파일업로드
    public String save(@RequestBody List<MultipartFile> files,
                       @RequestParam("aboutTableType") AboutTableType aboutTableType,
                       @RequestParam("idInTableType") Integer idInTableType
                       ) throws IOException {
//        attachmentService.save(files, aboutTableType, idInTableType);
        attachmentService.save(files, aboutTableType, idInTableType); // 테스트 데이터
        return "첨부파일 create 완료";
    }

    @GetMapping("/{aboutTableType}/{idInTableType}")
    public List<AttachmentVO> getList(@PathVariable AboutTableType aboutTableType,
                                      @PathVariable Integer idInTableType) {
//        attachmentService.getlist(aboutTableType, idInTableType);
        return attachmentService.getList(aboutTableType, idInTableType); // 테스트 데이터
    }

    @DeleteMapping // 파일삭제
    public String remove(@RequestBody List<Integer> attachmentIdList) {
        attachmentService.remove(attachmentIdList);
//        attachmentService.remove(attachmentIdList);
        return "첨부파일 delete 완료";
    }

    @DeleteMapping("/{aboutTableType}/{idInTableType}") // 파일삭제
    public String removeByTableId(@PathVariable AboutTableType aboutTableType,
                         @PathVariable Integer idInTableType) {
        attachmentService.removeByTableId(aboutTableType, idInTableType);
//        attachmentService.remove(attachmentIdList);
        return "첨부파일 delete 완료";
    }

}