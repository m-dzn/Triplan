package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    NONE("없음"),
    MALE("남자"),
    FEMALE("여자"),
    ETC("기타");


    private String explain;



}
