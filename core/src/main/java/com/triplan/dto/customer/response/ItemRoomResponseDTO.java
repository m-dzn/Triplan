package com.triplan.dto.customer.response;

import com.triplan.domain.ItemVO;
import com.triplan.domain.RoomVO;
import com.triplan.enumclass.ItemCategory;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRoomResponseDTO {

    private Integer itemId;

    private String name;
    private String explain;
    private ItemCategory itemCategory;

    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;

    private RoomVO roomVO;

    public static ItemRoomResponseDTO of(ItemVO vo){

        return ItemRoomResponseDTO.builder()
                .itemId(vo.getItemId())
                .name(vo.getName())
                .explain(vo.getExplain())
                .itemCategory(vo.getItemCategory())
                .baseStock(vo.getBaseStock())
                .salesVolume(vo.getSalesVolume())
                .detailImg(vo.getDetailImg())
                .build();

    }

}
