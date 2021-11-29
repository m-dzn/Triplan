package com.triplan.dto.response.seller;

import com.triplan.domain.item.ItemGroupVO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ItemGroupResponseDTO {

    // ItemGroupVO에서 필요한 컬럼들
    private Integer itemGroupId;
    private String name;
    private String summaryExplain;

    // ItemVO에서 필요한 컬럼들
    private List<ItemResponseDTO> itemList;

    // 아이템 그룹 VO 의 응답 DTO를 만드는 static 메서드
    public static ItemGroupResponseDTO of(ItemGroupVO vo) {

        return ItemGroupResponseDTO.builder()
                .itemGroupId(vo.getItemGroupId())
                .name(vo.getName())
                .summaryExplain(vo.getSummaryExplain())
                .build();
    }
}
