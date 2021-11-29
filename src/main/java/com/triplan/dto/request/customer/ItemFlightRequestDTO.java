package com.triplan.dto.request.customer;

import com.triplan.domain.item.FlightVO;
import com.triplan.domain.item.ItemVO;
import com.triplan.enumclass.item.FlightType;
import com.triplan.enumclass.item.ItemCategory;
import com.triplan.enumclass.item.SeatClass;
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
public class ItemFlightRequestDTO {

    private Integer itemId;
    @NotNull
    @NotBlank
    private String name;
    @NotBlank
    private String explain;
    @NotBlank
    private ItemCategory itemCategory;

    @PositiveOrZero
    @NotBlank
    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;

    @NotBlank
    @NotNull
    @Positive
    private Integer itemGroupId;
/////////////////////////////////////
    private Integer flightId;

    @NotBlank
    private String departure;
    @NotBlank
    private String destination;
    @NotBlank
    private FlightType flightType;
    @NotBlank
    private SeatClass seatClass;

    @PositiveOrZero
    private Integer minAge;
    @PositiveOrZero
    private Integer maxAge;

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

    public FlightVO toFlightVO(){
        return FlightVO.builder()
                .flightId(flightId)
                .departure(departure)
                .destination(destination)
                .flightType(flightType)
                .seatClass(seatClass)
                .minAge(minAge)
                .maxAge(maxAge)
                .build();
    }
}
