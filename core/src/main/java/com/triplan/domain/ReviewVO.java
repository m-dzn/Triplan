package com.triplan.domain;

import com.triplan.enumclass.ReviewScore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewVO extends BaseVO {

    // 식별자 필드

    private Integer reviewId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String content;

    // Default 값이 있는 NOT NULL 필드
    private Integer reviewScore;

    // Nullable 필드
    private String reviewImg;


    // 외래키
    private Integer memberId;
    private Integer itemId;


}
