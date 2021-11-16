package com.triplan.controller.api;

import com.triplan.domain.ReviewVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.AboutTableType;
import com.triplan.service.inf.ReviewService;
import javafx.application.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor

public class ApiReviewController {

    private final ReviewService reviewService;

    // TODO : 안 쓰는 REST 메서드 주석 or 삭제하기
    @PostMapping
    public String reviewInsert(@Valid @RequestBody ReviewVO reviewVO){
        reviewService.reviewInsert(reviewVO);
        return "정보 입력 성공";
    }

    @GetMapping("/{reviewId}")
    public ReviewVO reviewRead(@PathVariable Integer reviewId){
        ReviewVO result = reviewService.reviewRead(reviewId);
        return result;
    }

    @PutMapping("/{reviewId}")
    public String reviewUpdate(@PathVariable Integer reviewId, @RequestBody ReviewVO reviewVO){
        reviewService.reviewUpdate(reviewId, reviewVO);
        return "정보 수정 완료";
    }

   @DeleteMapping("/{reviewId}")
    public String reviewDelete(@PathVariable Integer reviewId){
        reviewService.reviewDelete(reviewId);
        return "정보 삭제 완료";
    }

    @GetMapping("/list")
    public List<ReviewVO> reviewList(){
        List<ReviewVO> list = reviewService.reviewList();
        return list;
    }




    /* 페이징 처리 */
    @GetMapping("/items/{itemId}")
    public Pagination<ReviewVO> reviewPage(
            @PathVariable Integer itemId,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage){

        return reviewService.page(itemId,pageSize,currentPage);
    }




}
