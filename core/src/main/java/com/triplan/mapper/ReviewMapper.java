package com.triplan.mapper;

import com.triplan.domain.ReviewVO;
import com.triplan.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    void insert(ReviewVO reviewVO);

    ReviewVO select(Integer reviewId);

    void update(ReviewVO reviewVO);

    void delete(Integer reviewId);

    List<ReviewVO> list();

    List<ReviewDTO> listByItemGroupId(@Param("itemGroupId") Integer itemGroupId, @Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);

    int countByItemGroupId(Integer itemId);

}
