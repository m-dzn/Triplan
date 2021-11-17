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

        if (files.isEmpty()) return;

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
    public void update(Integer sellerId, SellerVO sellerVO) {
        sellerVO.setSellerId(sellerId);
        sellerMapper.update(sellerVO);
    }

    @Override
    public void delete(Integer sellerId) {
        sellerMapper.delete(sellerId);
    }

}
