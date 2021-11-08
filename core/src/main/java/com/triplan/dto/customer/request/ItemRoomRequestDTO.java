package com.triplan.dto.customer.request;

import com.triplan.domain.RoomVO;
import com.triplan.domain.SellerVO;
import com.triplan.enumclass.ItemCategory;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemRoomRequestDTO {

    private Integer itemId;

    private String name;
    private String explain;
    private ItemCategory itemCategory;

    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;

    private Integer itemGroupId;

}
