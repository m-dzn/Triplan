package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.domain.ReviewVO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.mapper.ReviewMapper;
import com.triplan.service.inf.ReviewService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;
    private final AttachmentMapper attachmentMapper;



    @Override
    public void reviewInsert(ReviewVO reviewVO) {
       reviewMapper.insert(reviewVO);
    }


    @Override
    @Transactional
    public void reviewInsert(ReviewVO reviewVO, List<MultipartFile> files, AboutTableType aboutTableType) throws IOException  {


        List<AttachmentVO> attachmentList
                = AttachmentUtil.getAttachments(files,aboutTableType,reviewVO.getReviewId());


        reviewVO.setReviewImg(attachmentList.get(0).getUrl());

        reviewMapper.insert(reviewVO);

        try {
            attachmentMapper.insert(attachmentList);

        }catch (Exception e){
            AttachmentUtil.deleteAttachments(attachmentList);
        }

    }

    @Override
    public ReviewVO reviewRead(Integer reviewId) {
        return reviewMapper.select(reviewId);
    }

    @Override
    public void reviewUpdate(Integer reviewId, ReviewVO reviewVO) {
        reviewVO.setReviewId(reviewId);
        reviewMapper.update(reviewVO);
    }

    @Override
    public void reviewDelete(Integer reviewId) {
        reviewMapper.delete(reviewId);
    }

    @Override
    public List<ReviewVO> reviewList() {
        return reviewMapper.list();
    }




}
