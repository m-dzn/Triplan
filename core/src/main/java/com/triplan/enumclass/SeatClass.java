package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeatClass {
    ECONOMY("이코노미"),
    BUSINESS("비즈니스"),
    FIRST("퍼스트");

    private String sit;
}
