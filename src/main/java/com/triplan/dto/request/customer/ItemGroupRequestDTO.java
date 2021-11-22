package com.triplan.dto.request.customer;

import com.triplan.domain.item.ItemGroupVO;
import com.triplan.enumclass.item.ItemCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemGroupRequestDTO {

    private Integer itemGroupId;

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

    private String addressDetail;
    private String itemImg;
    private String detailImg;
    @PositiveOrZero
    private Integer location;
    @PositiveOrZero
    private Integer lat;
    @PositiveOrZero
    private Integer lng;
    @PositiveOrZero
    @NotBlank
    @NotNull
    private Integer likeCount;
    @PositiveOrZero
    @NotBlank
    @NotNull
    private Integer reviewCount;

    @NotBlank
    @NotNull
    @Positive
    private Integer sellerId;
    @Positive
    private List<Integer> tagIdList;

    public ItemGroupVO toItemGroupVO(){
        return ItemGroupVO.builder()
                .itemGroupId(itemGroupId)
                .name(name)
                .summaryExplain(summaryExplain)
                .detailExplain(detailExplain)
                .itemCategory(itemCategory)
                .address(address)
                .addressDetail(addressDetail)
                .itemImg(itemImg)
                .detailImg(detailImg)
                .location(location)
                .lat(lat)
                .lng(lng)
                .likeCount(likeCount)
                .reviewCount(reviewCount)
                .sellerId(sellerId)
                .build();
    }

}
