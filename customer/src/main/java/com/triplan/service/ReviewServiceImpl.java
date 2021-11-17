package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.domain.ReviewVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.AboutTableType;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.mapper.ReviewMapper;
import com.triplan.service.inf.ReviewService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;
    private final AttachmentMapper attachmentMapper;



    @Override
    public void reviewInsert(ReviewVO reviewVO) {
       reviewMapper.insert(reviewVO);
       reviewInsert(reviewVO, null, AboutTableType.REVIEW);
    }

    @Override
    @Transactional
    public void reviewInsert(ReviewVO reviewVO, List<MultipartFile> files, AboutTableType aboutTableType) {


        reviewMapper.insert(reviewVO);
        List<AttachmentVO> attachmentList
                = AttachmentUtil.getAttachments(files,aboutTableType,reviewVO.getReviewId());


        if (!attachmentList.isEmpty()) {
            reviewVO.setReviewImg(attachmentList.get(0).getUrl());

            try {
                attachmentMapper.insert(attachmentList);

            } catch (Exception e){
                AttachmentUtil.deleteAttachments(attachmentList);
            }
        }

        reviewMapper.updateUrl(reviewVO);

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
    @Transactional
    public ReviewVO reviewUpdate(ReviewVO reviewVO, List<MultipartFile> files) {
        List<AttachmentVO> attachmentList = AttachmentUtil.getAttachments(files, AboutTableType.REVIEW, reviewVO.getReviewId());

        if (!files.isEmpty()) {
            List<AttachmentVO> filesToDelete = attachmentMapper.select(AboutTableType.REVIEW.name(), reviewVO.getReviewId());
            AttachmentUtil.deleteAttachments(filesToDelete);
            attachmentMapper.delete(AboutTableType.REVIEW.name(), reviewVO.getReviewId());
            reviewVO.setReviewImg("");
        }

        if (!attachmentList.isEmpty()) {
            reviewVO.setReviewImg(attachmentList.get(0).getUrl());

            try {
                attachmentMapper.insert(attachmentList);

            } catch (Exception e){
                AttachmentUtil.deleteAttachments(attachmentList);
            }
        }

        reviewMapper.update(reviewVO);

        return reviewVO;
    }

    @Override
    public void reviewDelete(Integer reviewId) {
         reviewMapper.delete(reviewId);
    }

    @Override
    public void reviewDelete(String aboutTableType, Integer idInTableType) {


        reviewMapper.delete(idInTableType);
        List<AttachmentVO> list = attachmentMapper.select(aboutTableType,idInTableType);
        AttachmentUtil.deleteAttachments(list);

        for(int i=0;list.size()>i;i++){
            idInTableType = list.get(i).getAttachmentId();
            attachmentMapper.delete(aboutTableType,idInTableType);

        }

    }


    @Override
    public List<ReviewVO> reviewList() {
        return reviewMapper.list();
    }

    /* 페이징 처리 */
    @Override
    public Pagination<ReviewVO> page(Integer itemId, Integer pageSize, Integer currentPage) {

        List<ReviewVO> reviewPage = reviewMapper.page(pageSize,currentPage);
        int totalReviews = reviewMapper.count(itemId);

        return new Pagination<>(pageSize,currentPage,totalReviews,reviewPage);
    }


}
