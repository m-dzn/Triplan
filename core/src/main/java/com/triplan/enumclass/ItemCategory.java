package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemCategory implements BaseEnum {

    ROOM("객실"),
    FLIGHT("항공권"),
    PACKAGE("패키지");

    private final String explain;

}
