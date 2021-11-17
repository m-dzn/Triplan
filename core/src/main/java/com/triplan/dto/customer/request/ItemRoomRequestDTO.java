package com.triplan.dto.customer.request;

import com.triplan.domain.ItemVO;
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
/////////////////////////////////////
    private Integer roomId;

    private Integer numberOfPerson;
    private Integer maxPerson;


    public ItemVO toItemVO() {
        return ItemVO.builder()
                .itemId(itemId)
                .name(name)
                .explain(explain)
                .itemCategory(itemCategory)
                .baseStock(baseStock)
                .salesVolume(salesVolume)
                .detailImg(detailImg)
                .itemGroupId(itemGroupId)
                .build();
    }

    public RoomVO toRoomVO(){
        return RoomVO.builder()
                .roomId(roomId)
                .numberOfPerson(numberOfPerson)
                .maxPerson(maxPerson)
                .build();
    }
}
