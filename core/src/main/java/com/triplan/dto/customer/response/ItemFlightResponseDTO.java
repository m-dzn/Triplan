package com.triplan.dto.customer.response;

import com.triplan.domain.FlightVO;
import com.triplan.domain.ItemVO;
import com.triplan.enumclass.ItemCategory;
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
