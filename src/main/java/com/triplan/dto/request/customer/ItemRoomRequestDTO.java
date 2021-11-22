package com.triplan.dto.request.customer;

import com.triplan.domain.item.ItemVO;
import com.triplan.domain.item.RoomVO;
import com.triplan.enumclass.item.ItemCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemRoomRequestDTO {

    private Integer itemId;

    @NotBlank
    private String name;
    @NotBlank
    private String explain;
    @NotBlank
    private ItemCategory itemCategory;

    @PositiveOrZero
    private Integer baseStock;
    @PositiveOrZero
    private Integer salesVolume;
    private String detailImg;

    @NotBlank
    @NotNull
    @Positive
    private Integer itemGroupId;
/////////////////////////////////////
    private Integer roomId;

    @NotBlank
    @PositiveOrZero
    private Integer numberOfPerson;
    @PositiveOrZero
    private Integer maxPerson;


    public ItemVO toItemVO() {
        return ItemVO.builder()
                .itemId(itemId)
                .name(name)
                .explain(explain)
                .itemCategory(itemCategory)
                .baseStock(baseStock)
                .salesVolume(salesVolume)
                .detailImg(detailImg)
                .itemGroupId(itemGroupId)
                .build();
    }

    public RoomVO toRoomVO(){
        return RoomVO.builder()
                .roomId(roomId)
                .numberOfPerson(numberOfPerson)
                .maxPerson(maxPerson)
                .build();
    }
}
