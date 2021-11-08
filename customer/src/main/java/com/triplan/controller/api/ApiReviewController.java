package com.triplan.controller.api;


import com.triplan.domain.ReviewVO;
import com.triplan.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ApiReviewController {


    private final ReviewService reviewService;

    @PostMapping("/reviewInsert")
    public String reviewInsert(@RequestBody ReviewVO reviewVO){
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
        reviewService.reviewUpdate(reviewId,reviewVO);
        return "정보 수정 완료";
    }

    @DeleteMapping("/{reviewId}")
    public String reviewDelete(@PathVariable Integer reviewId){
        reviewService.reviewDelete(reviewId);
        return "정보 삭제 완료";
    }






}
