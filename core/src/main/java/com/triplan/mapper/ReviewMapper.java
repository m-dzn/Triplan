package com.triplan.mapper;

import com.triplan.domain.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

    void reviewInsert(ReviewVO reviewVO);

    ReviewVO reviewRead(Integer reviewId);

    void reviewUpdate(ReviewVO reviewVO);

    void reviewDelete(Integer reviewId);
}
