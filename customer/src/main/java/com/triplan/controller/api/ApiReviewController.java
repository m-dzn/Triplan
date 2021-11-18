package com.triplan.controller.api;

import com.triplan.domain.ReviewVO;
import com.triplan.dto.response.Pagination;
import com.triplan.service.inf.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor

public class ApiReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public String reviewInsert(
            @RequestPart("review") @Valid ReviewVO reviewVO,
            @RequestPart("file") List<MultipartFile> files
    ) {
        reviewService.reviewInsert(reviewVO, files);
        return "정보 입력 성공";
    }

    @GetMapping("/{reviewId}")
    public ReviewVO reviewRead(@PathVariable Integer reviewId) {
        ReviewVO result = reviewService.reviewRead(reviewId);
        return result;
    }

    @PutMapping(value = "/{reviewId}")
    public String reviewUpdate(
            @PathVariable Integer reviewId,
            @RequestPart("review") ReviewVO reviewVO,
            @RequestPart("file") List<MultipartFile> files
    ) {
        reviewVO.setReviewId(reviewId);
        reviewService.reviewUpdate(reviewVO, files);
        return "정보 수정 완료";
    }

   @DeleteMapping("/{reviewId}")
    public String reviewDelete(@PathVariable Integer reviewId){
        reviewService.reviewDelete(reviewId);
        return "정보 삭제 완료";
    }

    @GetMapping
    public List<ReviewVO> reviewList(){
        List<ReviewVO> list = reviewService.reviewList();
        return list;
    }

    /* 페이징 처리 */
    @GetMapping("/items/{itemId}")
    public Pagination<ReviewVO> reviewPage(
            @PathVariable Integer itemId,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage
    ) {
        return reviewService.page(itemId, pageSize, currentPage);
    }

}
