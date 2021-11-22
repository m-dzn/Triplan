package com.triplan.dto.response.customer;

import com.triplan.domain.item.FlightVO;
import com.triplan.domain.item.ItemVO;
import com.triplan.enumclass.item.ItemCategory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemFlightResponseDTO {

    private Integer itemId;

    private String name;
    private String explain;
    private ItemCategory itemCategory;

    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;
    private LocalDateTime createdAt;

    private FlightVO flightVO;

    public static ItemFlightResponseDTO of(ItemVO vo){

        return ItemFlightResponseDTO.builder()
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
