package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemType {
    roomItem(0,"객실"),
    packageItem(1,"패키지"),
    flightItem(2,"항공권");

    private Integer code;
    private String explain;
}
