package com.triplan.service;

import com.triplan.domain.ReviewVO;

public interface ReviewService {
    void reviewInsert(ReviewVO reviewVO);

    ReviewVO reviewRead(Integer reviewId);

    void reviewUpdate(Integer reviewId, ReviewVO reviewVO);

    void reviewDelete(Integer reviewId);


}
