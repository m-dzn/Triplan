package com.triplan.domain.item;

import com.triplan.enumclass.item.FlightType;
import com.triplan.enumclass.item.SeatClass;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FlightVO {

    // 식별자 필드
    private Integer flightId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    @NotBlank
    private String departure;
    @NotBlank
    private String destination;
    @NotBlank
    private FlightType flightType;
    @NotBlank
    private SeatClass seatClass;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    @PositiveOrZero
    private Integer minAge;
    @PositiveOrZero
    private Integer maxAge;
    
    // 외래키
    private Integer itemId;

}
