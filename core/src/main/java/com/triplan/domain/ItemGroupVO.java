package com.triplan.domain;

import com.triplan.enumclass.ItemCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ItemGroupVO extends BaseVO {

    // 식별자 필드
    private Integer itemGroupId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    @NotBlank
    private String name;
    private String summaryExplain;
    private String detailExplain;

    @NotBlank
    private ItemCategory itemCategory;
    private String address;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private String addressDetail;
    private String itemImg;
    private String detailImg;
    private Integer location;
    private Integer lat;
    private Integer lng;
    private Integer likeCount;
    private Integer reviewCount;
    
    // 외래키
    @NotBlank
    private Integer sellerId;

}
