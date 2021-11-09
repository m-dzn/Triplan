package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.service.inf.AttachmentService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentMapper attachmentMapper;
    private final AttachmentUtil attachmentUtil;

    @Override
    public void save(List<MultipartFile> files, AboutTableType tableType, int id) throws IOException {
        List<AttachmentVO> attachmentList = attachmentUtil.getAttachments(files, tableType, id);


        try { // db작업중에 에러뜨면 서버에 저장한 파일도 삭제
            attachmentMapper.insert(attachmentList);
        } catch (Exception e) {
            attachmentUtil.deleteAttachments(attachmentList);
        }

    }

    @Override
    public void remove(AboutTableType tableType, int id) {
        List<AttachmentVO> attachmentList = attachmentMapper.select(tableType.name(), id);
            // 삭제하려는 테이블타입, 글번호와 일치하는 행들 전부 반환

        attachmentUtil.deleteAttachments(attachmentList); // 물리적으로 파일 삭제
        attachmentMapper.delete(tableType.name(), id);  // db에서 파일삭제

    }


    @Override
    public List<AttachmentVO> getlist(AboutTableType aboutTableType, int idInTableType) {
        return attachmentMapper.select(aboutTableType.name(), idInTableType);
    }


    @Override
    public void remove(List<Integer> attachmentIdList) {
        List<AttachmentVO> attachmentList = attachmentMapper.selectByAttachmentId(attachmentIdList);

        attachmentUtil.deleteAttachments(attachmentList); // 물리적으로 파일 삭제
        for(Integer attachmentId : attachmentIdList) {
            attachmentMapper.deleteByAttachmentId(attachmentId); // db에서 파일 삭제

        }
    }


}
