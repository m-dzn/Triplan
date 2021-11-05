package com.triplan.domain;

import com.triplan.enumclass.ReviewScore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ReviewVO {

    private Integer reviewId;
    private Integer memberId;
    private Integer itemId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ReviewScore reviewScore; // Enum 0,0.5,.... 5점까지


}
