package com.triplan.dto.seller.response;

import com.triplan.domain.ItemScheduleVO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemScheduleResponseDTO {

    private Integer itemScheduleId;
    private Long price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer stock;
    private Long discountPrice;
    private Integer itemId;

    public static ItemScheduleResponseDTO of(ItemScheduleVO vo) {
        return ItemScheduleResponseDTO.builder()
                .itemScheduleId(vo.getItemScheduleId())
                .price(vo.getPrice())
                .startDate(vo.getStartDate())
                .endDate(vo.getEndDate())
                .stock(vo.getStock())
                .discountPrice(vo.getDiscountPrice())
                .itemId(vo.getItemId())
                .build();
    }

}