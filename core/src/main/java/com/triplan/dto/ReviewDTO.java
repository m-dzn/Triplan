package com.triplan.dto;

import com.triplan.domain.ReviewVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class ReviewDTO {


    private Integer reviewId;
    private String content;
    private Integer reviewScore;
    private String reviewImg;

    private Integer memberId;
    private Integer itemId;

    public static ReviewDTO of (ReviewVO reviewVO){
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(reviewVO.getReviewId());
        dto.setContent(reviewVO.getContent());
        dto.setReviewScore(reviewVO.getReviewScore());
        dto.setMemberId(reviewVO.getMemberId());
        dto.setItemId(reviewVO.getItemId());
        dto.setReviewImg(reviewVO.getReviewImg());
        return dto;
    }


    public ReviewVO toVO() {
        ReviewVO vo = new ReviewVO();

        vo.setContent(getContent());
        vo.setReviewImg(getReviewImg());


        return vo;

    }
}
