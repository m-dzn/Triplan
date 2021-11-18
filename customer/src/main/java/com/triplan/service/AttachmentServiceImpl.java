package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.service.inf.AttachmentService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentMapper attachmentMapper;

    @Override
    public void save(List<MultipartFile> files, AboutTableType aboutTableType, Integer idInTableType) {
        AttachmentVO attachmentVO = AttachmentUtil.getAttachment(files.get(0), aboutTableType, idInTableType);

        try { // db작업중에 에러뜨면 서버에 저장한 파일도 삭제
            attachmentMapper.insert(attachmentVO);
        } catch (Exception e) {
            AttachmentUtil.deleteAttachment(attachmentVO);
        }
    }

    @Override
    public void remove(List<Integer> attachmentIdList) {
        // 삭제하려는 테이블타입, 글번호와 일치하는 행들 전부 반환
        List<AttachmentVO> attachmentList = attachmentMapper.selectAllByAttachmentId(attachmentIdList);

        AttachmentUtil.deleteAttachments(attachmentList); // 물리적으로 파일 삭제
        attachmentMapper.deleteAllByAttachmentId(attachmentIdList);  // DB에서 파일 삭제
    }

    @Override
    public void removeByTableId(AboutTableType aboutTableType, Integer idInTableType) {
        List<AttachmentVO> attachmentList = attachmentMapper.selectAll(aboutTableType, idInTableType);
        AttachmentUtil.deleteAttachments(attachmentList);
    }

    @Override
    public List<AttachmentVO> getList(AboutTableType aboutTableType, Integer idInTableType) {
        return attachmentMapper.selectAll(aboutTableType, idInTableType);
    }

}
