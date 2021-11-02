package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberGrade {

    BRONZE(1,"브론즈"),
    SILVER(2,"실버"),
    GOLD(3,"골드"),
    PLATINUM(4,"플래티넘");

    private Integer code;
    private String kor;
}
