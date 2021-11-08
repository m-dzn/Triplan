package com.triplan.dto.seller.response;

import com.triplan.domain.ItemScheduleVO;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemScheduleResponseDTO {

    private Integer itemScheduleId;
    private Long price;
    private Integer stock;

    public static ItemScheduleResponseDTO of(ItemScheduleVO vo) {
        return ItemScheduleResponseDTO.builder()
                .itemScheduleId(vo.getItemScheduleId())
                .price(vo.getPrice())
                .stock(vo.getStock())
                .build();
    }
}