package com.triplan.service.inf;

import com.triplan.domain.ReviewVO;
import com.triplan.enumclass.AboutTableType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ReviewService {


    void reviewInsert(ReviewVO reviewVO, List<MultipartFile> files, AboutTableType aboutTableType) throws IOException;

    ReviewVO reviewRead(Integer reviewId);

    void reviewUpdate(Integer reviewId, ReviewVO reviewVO);

    void reviewDelete(Integer reviewId);

    List<ReviewVO> reviewList();

    void reviewInsert(ReviewVO reviewVO);



}
