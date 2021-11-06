package com.triplan.service;

import com.triplan.domain.ReviewVO;
import com.triplan.mapper.ReviewMapper;
import com.triplan.service.inf.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    @Override
    public void reviewInsert(ReviewVO reviewVO) {
        reviewMapper.insert(reviewVO);
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

}
