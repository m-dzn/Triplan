package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlightType implements BaseEnum {

    ONE_WAY("편도"),
    BOTH_WAYS("왕복");

    private final String explain;

}
