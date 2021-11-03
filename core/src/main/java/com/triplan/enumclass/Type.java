package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type{
    CARD("카드"),
    CASH("현금"),
    NOBANKBOOK("무통장"),
    KAKAOPAY("카카오페이");

    private String explain;
}