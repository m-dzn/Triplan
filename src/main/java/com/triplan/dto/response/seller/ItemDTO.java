package com.triplan.dto.response.seller;

import com.triplan.domain.item.ItemVO;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Integer itemId;
    private String name;
    private Integer salesVolume;

    public static ItemDTO of(ItemVO vo) {

        return ItemDTO.builder()
                .itemId(vo.getItemId())
                .name(vo.getName())
                .salesVolume(vo.getSalesVolume())
                .build();
    }
}
