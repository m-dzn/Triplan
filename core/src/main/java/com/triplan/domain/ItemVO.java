package com.triplan.domain;

import com.triplan.enumclass.ItemCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemVO extends BaseVO {

    // 식별자 필드
    private Integer itemId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String name;
    private String explain;
    private ItemCategory itemCategory;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;

    // 외래키
    private Integer itemGroupId;

}
