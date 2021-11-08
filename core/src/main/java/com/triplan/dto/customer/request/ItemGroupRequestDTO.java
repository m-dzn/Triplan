package com.triplan.dto.customer.request;

import com.triplan.domain.ItemGroupVO;
import com.triplan.enumclass.ItemCategory;
import lombok.*;

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

}
