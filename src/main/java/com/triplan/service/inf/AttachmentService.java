package com.triplan.service.inf;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService {
    
    // 파일업로드
    void save(List<MultipartFile> files, AboutTableType aboutTableType, Integer idInTableType);

    // 해당글의 파일목록
    List<AttachmentVO> getList(AboutTableType aboutTableType, Integer idInTableType);

    // 글 삭제시 해당글의 파일 전부 삭제
    void remove(List<Integer> attachmentIdList);

    void removeByTableId(AboutTableType aboutTableType, Integer idInTableType);
}
