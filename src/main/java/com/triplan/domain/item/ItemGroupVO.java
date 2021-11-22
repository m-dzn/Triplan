package com.triplan.domain.item;

import com.triplan.domain.BaseVO;
import com.triplan.enumclass.item.ItemCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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
    @NotBlank
    private String summaryExplain;
    @NotBlank
    private String detailExplain;
    @NotBlank
    private ItemCategory itemCategory;
    @NotBlank
    private String address;

    // Default 값이 있는 NOT NULL 필드
    @PositiveOrZero
    private Integer likeCount;
    @PositiveOrZero
    private Integer reviewCount;

    // Nullable 필드
    private String addressDetail;
    private String itemImg;
    private String detailImg;
    private Integer location;
    private Integer lat;
    private Integer lng;
    
    // 외래키
    @NotBlank
    @NotNull
    private Integer sellerId;

    public void increaseLikeCount() {
        likeCount++;
    }

    public void decreaseLikeCount() {
        if (likeCount > 0) {
            likeCount--;
        }
    }

}
