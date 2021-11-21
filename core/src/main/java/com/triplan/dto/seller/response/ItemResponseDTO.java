package com.triplan.dto.seller.response;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import com.triplan.enumclass.ItemCategory;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {

    // ItemVO의 필드
    private Integer itemId;
    private String name;
    private String explain;
    private ItemCategory itemCategory;
    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;
    private ItemGroupVO itemGroup;

    // 기타 필드
    private Long totalPrice;
    private Long totalDiscount;
    private List<ItemScheduleResponseDTO> itemScheduleList;

    public static ItemResponseDTO of(ItemVO vo) {
        return ItemResponseDTO.builder()
                .itemId(vo.getItemId())
                .name(vo.getName())
                .explain(vo.getExplain())
                .itemCategory(vo.getItemCategory())
                .baseStock(vo.getBaseStock())
                .salesVolume(vo.getSalesVolume())
                .detailImg(vo.getDetailImg())
                .build();
    }

    public Long getPriceToPay() {
        return totalPrice - totalDiscount;
    }

}