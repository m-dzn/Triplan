package com.triplan.dto.response.customer;

import com.triplan.domain.item.ItemGroupVO;
import com.triplan.domain.item.TagVO;
import com.triplan.enumclass.item.ItemCategory;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemGroupResponseDTO {

    private Integer itemGroupId;

    private String name;
    private String summaryExplain;
    private String detailExplain;
    private ItemCategory itemCategory;
    private String address;

    private String addressDetail;
    private String itemImg;
    private String detailImg;
    private String location;
    private Integer lat;
    private Integer lng;
    private Integer likeCount;
    private Integer reviewCount;
    private Integer sellerId;

    private List<ItemRoomResponseDTO> itemRoomList;
    private List<ItemFlightResponseDTO> itemFlightList;
    private List<TagVO> tagList;

    // 기타 컬럼
    private Boolean liked;


    public static ItemGroupResponseDTO of(ItemGroupVO vo) {

        return ItemGroupResponseDTO.builder()
                .itemGroupId(vo.getItemGroupId())
                .name(vo.getName())
                .summaryExplain(vo.getSummaryExplain())
                .detailExplain(vo.getDetailExplain())
                .itemCategory(vo.getItemCategory())
                .address(vo.getAddress())
                .addressDetail(vo.getAddressDetail())
                .itemImg(vo.getItemImg())
                .detailImg(vo.getDetailImg())
                .location(vo.getLocation())
                .lat(vo.getLat())
                .lng(vo.getLng())
                .likeCount(vo.getLikeCount())
                .reviewCount(vo.getReviewCount())
                .sellerId(vo.getSellerId())
                .build();
    }

}
