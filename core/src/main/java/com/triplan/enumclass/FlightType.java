package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlightType {

    ONE_WAY("편도"),
    BOTH_WAYS("왕복");

    private String explain;

}
