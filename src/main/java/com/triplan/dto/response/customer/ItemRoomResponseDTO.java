package com.triplan.dto.response.customer;

import com.triplan.domain.item.ItemVO;
import com.triplan.domain.item.RoomVO;
import com.triplan.enumclass.item.ItemCategory;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;

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
                .createdAt(vo.getCreatedAt())
                .build();

    }

}
