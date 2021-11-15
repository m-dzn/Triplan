package com.triplan.dto.customer.request;

import com.triplan.domain.ItemGroupTagVO;
import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.TagVO;
import com.triplan.enumclass.ItemCategory;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemGroupRequestDTO {

    private Integer itemGroupId;

    private String name;
    private String summaryExplain;
    private String detailExplain;
    private ItemCategory itemCategory;
    private String address;

    private String addressDetail;
    private String itemImg;
    private String detailImg;
    private Integer location;
    private Integer lat;
    private Integer lng;

    private Integer sellerId;
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
                .sellerId(sellerId)
                .build();
    }

}
