package com.triplan.dto.response;

import com.triplan.domain.ItemGroupVO;
import com.triplan.enumclass.ItemType;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
public class ItemGroupResponseDTO {

    // ItemGroupVO에서 필요한 컬럼들
    private Integer itemGroupId;
    private String itemGroupName;
    private String itemGroup;
    private ItemType type;
    private Integer minPurchaseQuantity;
    private Integer starScore;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // ItemVO에서 필요한 컬럼들
    private List<ItemResponseDTO> itemList;

    // 아이템 그룹 VO 의 응답 DTO를 만드는 static 메서드
    public static ItemGroupResponseDTO of(ItemGroupVO vo) {

        return ItemGroupResponseDTO.builder()
                .itemGroupId(vo.getItemGroupId())
                .itemGroupName(vo.getItemGroupName())
                .itemGroup(vo.getItemGroup())
                .type(vo.getType())
                .minPurchaseQuantity(vo.getMinPurchaseQuantity())
                .starScore(vo.getStarScore())
                .createdAt(vo.getCreatedAt())
                .updatedAt(vo.getUpdatedAt())
                .build();
    }
}
