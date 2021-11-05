package com.triplan.dto.response;

import com.triplan.domain.ItemVO;
import com.triplan.enumclass.ItemPrice;
import com.triplan.enumclass.ItemType;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {

    private Integer itemId;
    private String itemName;
    private Timestamp startDay;
    private Timestamp endDay;
    private ItemPrice price;
    private ItemType type;
    private Integer totalStock;
    private Integer totalSalesCount;
    private Integer discountPrice;

    public static ItemResponseDTO of(ItemVO vo) {
        return ItemResponseDTO.builder()
                .itemId(vo.getItemId())
                .itemName(vo.getItemName())
                .startDay(vo.getStartDay())
                .endDay(vo.getEndDay())
                .price(vo.getPrice())
                .type(vo.getType())
                .totalStock(vo.getTotalStock())
                .totalSalesCount(vo.getTotalSalesCount())
                .discountPrice(vo.getDiscountPrice())
                .build();
    }

}
