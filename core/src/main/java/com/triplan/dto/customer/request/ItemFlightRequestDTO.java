package com.triplan.dto.customer.request;

import com.triplan.domain.FlightVO;
import com.triplan.domain.ItemVO;
import com.triplan.domain.RoomVO;
import com.triplan.enumclass.FlightType;
import com.triplan.enumclass.ItemCategory;
import com.triplan.enumclass.SeatClass;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemFlightRequestDTO {

    private Integer itemId;

    private String name;
    private String explain;
    private ItemCategory itemCategory;

    private Integer baseStock;
    private Integer salesVolume;
    private String detailImg;

    private Integer itemGroupId;
/////////////////////////////////////
    private Integer flightId;

    private String departure;
    private String destination;
    private FlightType flightType;
    private SeatClass seatClass;

    private Integer minAge;
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
