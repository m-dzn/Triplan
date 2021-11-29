package com.triplan.dto.response.customer;

import com.triplan.domain.item.ReviewVO;
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
    private Integer itemGroupId;

    public static ReviewDTO of (ReviewVO reviewVO){
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(reviewVO.getReviewId());
        dto.setContent(reviewVO.getContent());
        dto.setReviewScore(reviewVO.getReviewScore());
        dto.setMemberId(reviewVO.getMemberId());
        dto.setItemGroupId(reviewVO.getItemGroupId());
        dto.setReviewImg(reviewVO.getReviewImg());
        return dto;
    }


    public ReviewVO toVO() {
        ReviewVO vo = new ReviewVO();

        vo.setReviewId(reviewId);
        vo.setContent(content);
        vo.setReviewScore(reviewScore);
        vo.setMemberId(memberId);
        vo.setItemGroupId(itemGroupId);
        vo.setReviewImg(reviewImg);

        return vo;

    }
}
