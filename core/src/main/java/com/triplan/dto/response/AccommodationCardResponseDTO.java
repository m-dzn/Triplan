package com.triplan.dto.response;

import com.triplan.enumclass.ItemCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccommodationCardResponseDTO {

    // ItemGroup 관련 필드
    private Integer itemGroupId;
    private String name;
    private ItemCategory itemCategory;
    private String address;
    private Integer likeCount;
    private Integer reviewCount;
    private String itemImg;
    private Integer location;
    private LocalDateTime createdAt;

    // 기타 컬럼
    private Integer pricePerDay;
    private Integer discountPerDay;
    private Boolean liked;

}
