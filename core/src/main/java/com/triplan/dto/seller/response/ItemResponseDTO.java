package com.triplan.dto.seller.response;

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

    private Integer itemId;
    private String name;
    private ItemCategory itemCategory;

    private List<ItemScheduleResponseDTO> itemScheduleList;

    public static ItemResponseDTO of(ItemVO vo) {
        return ItemResponseDTO.builder()
                .itemId(vo.getItemId())
                .name(vo.getName())
                .itemCategory(vo.getItemCategory())
                .build();
    }

}