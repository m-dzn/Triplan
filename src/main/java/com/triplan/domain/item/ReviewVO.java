package com.triplan.domain.item;

import com.triplan.domain.BaseVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewVO extends BaseVO {

    // 식별자 필드
    private Integer reviewId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드 > 빈칸, 띄어쓰기
    @NotBlank
    private String content;

    // Default 값이 있는 NOT NULL 필드 > 1-10
    @NotNull
    @Min(1)
    @Max(10)
    private Integer reviewScore;

    // Nullable 필드
    private String reviewImg;

    // 외래키 > 빈칸
    private Integer memberId;
    @NotNull
    private Integer itemGroupId;

}
