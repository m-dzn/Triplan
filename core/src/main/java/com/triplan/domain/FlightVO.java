package com.triplan.domain;

import com.triplan.enumclass.FlightType;
import com.triplan.enumclass.SeatClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FlightVO {

    // 식별자 필드
    private Integer flightId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String departure;
    private String destination;
    private FlightType flightType;
    private SeatClass seatClass;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private Integer minAge;
    private Integer maxAge;
    
    // 외래키
    private Integer itemId;

}
