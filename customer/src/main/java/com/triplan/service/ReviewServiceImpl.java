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
    @Transactional
    public void reviewInsert(ReviewVO reviewVO, List<MultipartFile> files) {
        reviewMapper.insert(reviewVO);

        if (!files.isEmpty()) return;

        AttachmentVO attachmentVO
                = AttachmentUtil.getAttachment(files.get(0), AboutTableType.REVIEW, reviewVO.getReviewId());

        if (attachmentVO != null) {
            reviewVO.setReviewImg(attachmentVO.getUrl());

            try {
                attachmentMapper.insert(attachmentVO);
                reviewMapper.update(reviewVO);
            } catch (Exception e){
                e.printStackTrace();
                AttachmentUtil.deleteAttachment(attachmentVO);
            }
        }
    }

    @Override
    public ReviewVO reviewRead(Integer reviewId) {
        return reviewMapper.select(reviewId);
    }

    @Override
    @Transactional
    public ReviewVO reviewUpdate(ReviewVO reviewVO, List<MultipartFile> files) {
        if (!files.isEmpty()) {
            // 기존 파일 삭제
            AttachmentVO oldAttachmentVO = attachmentMapper.select(AboutTableType.REVIEW, reviewVO.getReviewId());
            AttachmentUtil.deleteAttachment(oldAttachmentVO);
            attachmentMapper.delete(AboutTableType.REVIEW, reviewVO.getReviewId());
            reviewVO.setReviewImg("");
            
            // 새 파일 등록
            AttachmentVO newAttachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.REVIEW, reviewVO.getReviewId());

            if (newAttachmentVO != null) {
                reviewVO.setReviewImg(newAttachmentVO.getUrl());

                try {
                    attachmentMapper.insert(newAttachmentVO);
                } catch (Exception e){
                    e.printStackTrace();
                    AttachmentUtil.deleteAttachment(newAttachmentVO);
                }
            }
        }

        reviewMapper.update(reviewVO);
        return reviewVO;
    }

    @Override
    @Transactional
    public void reviewDelete(Integer reviewId) {
        reviewMapper.delete(reviewId);
        AttachmentVO attachmentVO = attachmentMapper.select(AboutTableType.REVIEW, reviewId);
        AttachmentUtil.deleteAttachment(attachmentVO);

        attachmentMapper.delete(AboutTableType.REVIEW, reviewId);
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
