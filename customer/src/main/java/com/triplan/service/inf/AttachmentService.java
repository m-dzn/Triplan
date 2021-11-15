package com.triplan.service.inf;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AttachmentService {
    
    // 파일업로드
    void save(List<MultipartFile> files, AboutTableType aboutTableType, Integer idInTableType) throws IOException;

    // 해당글의 파일목록
    List<AttachmentVO> getlist(AboutTableType aboutTableType, Integer idInTableType);

    // 글 수정시 해당글의 특정 파일만 삭제
    void remove(List<Integer> attachmentId);

    // 글 삭제시 해당글의 파일 전부 삭제
    void remove(AboutTableType aboutTableType, Integer idInTableType);

}
