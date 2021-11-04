package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    NONE(1,"없음"),
    MALE(2,"남자"),
    FEMALE(3,"여자"),
    ETC(4,"기타");

    private Integer code;
    private String explain;

    Gender(String explain){
        this.explain = explain;
    }

}
