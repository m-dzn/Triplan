package com.triplan.domain;

import com.triplan.enumclass.ItemCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemVO extends BaseVO {

    // 식별자 필드
    private Integer itemId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String name;
    private String explain;
    @NotBlank
    private ItemCategory itemCategory;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;

    // 외래키
    @NotBlank
    @NotNull
    private Integer itemGroupId;

}
