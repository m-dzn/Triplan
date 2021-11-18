package com.triplan.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RoomVO {
    // 식별자 필드
    private Integer roomId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private Integer numberOfPerson;
    @NotBlank
    private Integer maxPerson;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드

    // 외래키
    @NotBlank
    private Integer itemId;

}
