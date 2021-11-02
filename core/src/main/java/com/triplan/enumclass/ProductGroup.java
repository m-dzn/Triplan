package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductGroup {

    Flight(0,"항공권"),
    Room(1,"숙소"),
    Package(2,"패키지");

    private Integer code;
    private String explain;


}
