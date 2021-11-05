package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemType {

    ROOM("숙소"),
    FLIGHT("항공권"),
    PACKAGE("패키지");

    private String typeValue;

}
