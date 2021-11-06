package com.triplan.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoomVO {
    // 식별자 필드
    private Integer roomId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private Integer numberOfPerson;
    private Integer maxPerson;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private String img;

    // 외래키
    private Integer itemId;

}
