package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResType {
    CARD(0,"카드"),
    CASH(1,"현금"),
    NOBANKBOOK(2,"무통장"),
    KAKAOPAY(3,"카카오페이");

    private Integer code;
    private String explain;
}