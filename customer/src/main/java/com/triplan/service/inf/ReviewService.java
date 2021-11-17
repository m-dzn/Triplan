package com.triplan.service.inf;

import com.triplan.domain.ReviewVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.AboutTableType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReviewService {

    void reviewInsert(ReviewVO reviewVO);
    void reviewInsert(ReviewVO reviewVO, List<MultipartFile> files, AboutTableType aboutTableType);

    ReviewVO reviewRead(Integer reviewId);

    void reviewUpdate(Integer reviewId, ReviewVO reviewVO);

    ReviewVO reviewUpdate(ReviewVO reviewVO, List<MultipartFile> files);

    List<ReviewVO> reviewList();


    Pagination<ReviewVO> page(Integer itemId, Integer pageSize, Integer currentPage);

    void reviewDelete(Integer reviewId);

    void reviewDelete( String aboutTableType, Integer idInTableType);


    ;
}
