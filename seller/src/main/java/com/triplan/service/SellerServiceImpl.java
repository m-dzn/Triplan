package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.domain.SellerVO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.mapper.SellerMapper;
import com.triplan.service.inf.SellerService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerMapper sellerMapper;
    private final AttachmentMapper attachmentMapper;

    @Override
    @Transactional
    public void register(SellerVO sellerVO, List<MultipartFile> files) {
        sellerMapper.insert(sellerVO);

        if (files == null || files.isEmpty()) return;

        AttachmentVO attachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.SELLER, sellerVO.getSellerId());

        if (attachmentVO != null) {
            sellerVO.setSellerImg(attachmentVO.getUrl());

            try {
                attachmentMapper.insert(attachmentVO);
                sellerMapper.update(sellerVO);
            } catch (Exception e){
                e.printStackTrace();
                AttachmentUtil.deleteAttachment(attachmentVO);
            }
        }
    }

    @Override
    public SellerVO getSeller(Integer sellerId) {
        return sellerMapper.read(sellerId);
    }

    @Override
    @Transactional
    public void update(Integer sellerId, SellerVO sellerVO, List<MultipartFile> files) {
        sellerVO.setSellerId(sellerId);

        if (files != null && !files.isEmpty()) {
            // 기존 파일 삭제
            List<AttachmentVO> filesToDelete = attachmentMapper.select(AboutTableType.SELLER, sellerVO.getSellerId());
            AttachmentUtil.deleteAttachments(filesToDelete);
            attachmentMapper.delete(AboutTableType.SELLER, sellerVO.getSellerId());
            sellerVO.setSellerImg("");

            // 새 파일 등록
            AttachmentVO newAttachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.SELLER, sellerVO.getSellerId());

            if (newAttachmentVO != null) {
                sellerVO.setSellerImg(newAttachmentVO.getUrl());

                try {
                    attachmentMapper.insert(newAttachmentVO);
                } catch (Exception e){
                    e.printStackTrace();
                    AttachmentUtil.deleteAttachment(newAttachmentVO);
                }
            }
        }

        sellerMapper.update(sellerVO);
    }

    @Override
    public void delete(Integer sellerId) {
        sellerMapper.delete(sellerId);
        List<AttachmentVO> attachmentVO = attachmentMapper.select(AboutTableType.SELLER, sellerId);
        AttachmentUtil.deleteAttachments(attachmentVO);

        attachmentMapper.delete(AboutTableType.SELLER, sellerId);
    }

}
