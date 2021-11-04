package com.triplan.service;

import com.triplan.domain.ReviewVO;
import com.triplan.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;


    @Override
    public void reviewInsert(ReviewVO reviewVO) {
        reviewMapper.reviewInsert(reviewVO);
    }

    @Override
    public ReviewVO reviewRead(Integer reviewId) {
        return reviewMapper.reviewRead(reviewId);
    }

    @Override
    public void reviewUpdate(Integer reviewId, ReviewVO reviewVO) {
        reviewVO.setReviewId(reviewId);
        reviewMapper.reviewUpdate(reviewVO);
    }

    @Override
    public void reviewDelete(Integer reviewId) {
        reviewMapper.reviewDelete(reviewId);
    }
}
