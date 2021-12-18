package com.triplan.enumclass.member;

import com.triplan.enumclass.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberState implements BaseEnum {

    UNREGISTER("탈퇴"),
    REGISTER("등록"),
    PAUSE("계정 정지");

    private final String explain;

}
