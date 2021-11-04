package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductGroup{
    FLIGHT("항공"),
    ROOM("객실"),
    PACKAGE("패키지");

    private String explain;
}
