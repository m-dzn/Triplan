package com.triplan.service.inf;

import com.triplan.domain.ReviewVO;
import com.triplan.dto.ReviewDTO;
import com.triplan.dto.response.Pagination;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReviewService {

    void reviewInsert(ReviewVO reviewVO, List<MultipartFile> files);

    ReviewVO reviewRead(Integer reviewId);

    ReviewVO reviewUpdate(ReviewVO reviewVO, List<MultipartFile> files);

    List<ReviewVO> reviewList();

    Pagination<ReviewDTO> listByItemGroupId(Integer itemGroupId, Integer pageSize, Integer currentPage);

    void reviewDelete(Integer reviewId);

}
