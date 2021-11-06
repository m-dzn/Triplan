package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberState implements BaseEnum {

    UNREGISTER("탈퇴"),
    REGISTER("등록"),
    ACCOUNT_SUSPENSION("계정 정지");

    private final String explain;

}
