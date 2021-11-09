package com.triplan.controller.api;

import com.triplan.enumclass.AboutTableType;
import com.triplan.service.inf.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attachment")
public class ApiAttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping("/save") // 파일업로드
    public String save(@RequestBody List<MultipartFile> files) throws IOException {
//        attachmentService.save(files, aboutTableType, idInTableType);
        attachmentService.save(files, AboutTableType.REVIEW, 1); // 테스트 데이터
        return "첨부파일 create 완료";
    }

    @GetMapping("/getList") // 파일목록
    public String getList() {
//        attachmentService.getlist(aboutTableType, idInTableType);
        attachmentService.getlist(AboutTableType.REVIEW, 1); // 테스트 데이터
        return "첨부파일 read 완료";
    }

    @DeleteMapping("/remove") // 파일삭제
    public String remove(@RequestBody List<Integer> attachmentIdList) {
        List<Integer> idList = new ArrayList<>(); // 테스트 데이터
        idList.add(1);
        idList.add(3);
        attachmentService.remove(idList);
//        attachmentService.remove(attachmentIdList);
        return "첨부파일 delete 완료";
    }
}