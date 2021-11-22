package com.triplan.enumclass.item;

import com.triplan.enumclass.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeatClass implements BaseEnum {

    ECONOMY("이코노미"),
    BUSINESS("비즈니스");

    private final String explain;

}
