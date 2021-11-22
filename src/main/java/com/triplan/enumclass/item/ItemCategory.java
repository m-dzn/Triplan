package com.triplan.enumclass.item;

import com.triplan.enumclass.BaseEnum;
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
